package com.bd.eshopper.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth , DataSource dataSource) throws Exception{
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials , true  from users where username = ? ")
			.authoritiesByUsernameQuery("select users as principal , roles as role from  users_roles where users = ?")
			.rolePrefix("ROLE_");
	}
	
	@Override
	protected void configure(HttpSecurity http ) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()			    
				//.anyRequest().permitAll()			    
				  //.antMatchers("/").permitAll()
				/*.antMatchers(
						HttpMethod.GET ,
							"/api/vehicule/acrissCarCode1" ,
							"/api/vehicule/acrissCarCode2" ,
							"/api/vehicule/acrissCarCode3" ,
							"/api/vehicule/acrissCarCode4" ,
							"/api/vehicule/vehicule",
							"/api/vehicule/tarifsVehicule" ,
							"/api/vehicule/reservationVehicule",
							"/api/vehicule/prixVehicule",
							"/api/vehicule/devis").permitAll()
				.antMatchers("/reportReservationVehicule").permitAll()	
				 .antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")			
				.antMatchers("/acceuil.html").permitAll()
				.antMatchers("/optionsCode1Vehicule").hasRole("ADMIN")
				.anyRequest().authenticated()*/
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/index.html")
				.failureUrl("/url")
				.permitAll()
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.permitAll()
		        .and();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/index.html" ,
				"/bower_components/**",
				"/images/**",
				"/scripts/**",
				"/styles/**" ,
				"/views/**", 
				"/404.html" ,
				"/acceuil");
		
	}
	
}
