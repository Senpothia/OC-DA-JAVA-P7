package com.formation.projet7.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from utilisateur where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from user_profil up " + 
			"inner join utilisateur u on u.id = up.id_user " + 
			"inner join profil p on p.id = up.id_profil " + 
			"where u.username = ?");
	}

	/**
	 * Personalizamos el Acceso a las URLs de la aplicación
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() 
            	
    	// Los recursos estáticos no requieren autenticación
        .antMatchers(                
                "/images/*",
                "/css/*").permitAll()
        
        // Las vistas públicas no requieren autenticación
        .antMatchers(
        		"/biblio/"
				,"/biblio/presentation"
				,"/biblio/connexion"
				,"/biblio/compte").permitAll()
        
        // Asignar permisos a URLs por ROLES
        .antMatchers("/solicitudes/create/**",
        			 "/solicitudes/save/**").hasAuthority("USUARIO")
        
        .antMatchers("/solicitudes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
        
        // Todas las demás URLs de la Aplicación requieren autenticación
        .anyRequest().authenticated()
        // El formulario de Login no requiere autenticacion
        .and().formLogin().loginPage("/biblio/connexion")
        .defaultSuccessUrl("/biblio/espace").permitAll()        
        .and().logout().permitAll();
    }
	
	/**
	 *  Implementación de Spring Security que encripta passwords con el algoritmo Bcrypt
	 * @return
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
