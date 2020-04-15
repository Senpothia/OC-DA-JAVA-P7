package com.formation.projet7.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private DataSource dataSource; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers(
				"/css/*"
				,"/images/*").permitAll()
		.antMatchers(
				"/biblio/"
				,"/biblio/presentation"
				,"/biblio/compte").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/biblio/connexion")
		  .defaultSuccessUrl("/biblio/espace")
		  
          .failureUrl("/biblio/connexion?error=true")
          .permitAll()
          ;
		}
		
	@Bean
	public PasswordEncoder passwordEncoder () {
		
		return new BCryptPasswordEncoder();
	}
	
	public AuthenticationProvider authentificationProvider (SecurityService securityService, PasswordEncoder encoder) {
		
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(securityService);
		auth.setPasswordEncoder(encoder);
		return auth;
	}
		
	}
	


