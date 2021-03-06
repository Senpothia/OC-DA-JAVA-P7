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

import com.formation.projet7.service.jpa.ProfilService;

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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() 
            	
    	// Les ressources statiques ne requièrent pas d'authentification
        .antMatchers(                
                "/images/*",
                "/css/*").permitAll()
        
        // Les pages publiques ne requièrent pas d'authentification
        .antMatchers(
        		"/biblio/"
				,"/biblio/presentation"
				,"/biblio/connexion"
				,"/biblio/compte").permitAll()
            
        // Toutes les autres url requièrent une authentification
        .anyRequest().authenticated()
        // le formulaire de login ne requièrent pas d'authentification
        .and().formLogin().loginPage("/biblio/connexion")
        .defaultSuccessUrl("/biblio/espace").permitAll()        
        .and().logout().permitAll();
    }
		
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public ProfilService serviceProfil() {
		
		return new ProfilService();
	}

}