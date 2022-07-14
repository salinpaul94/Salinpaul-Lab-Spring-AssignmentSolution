package com.student.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("salinpaul")
		.password("$2a$10$oYUpECsJoXgiTwy7EJBIsO1b.fWY.PIs0MaxtH4ykr2waUaW8ZZV.")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("$2a$10$oYUpECsJoXgiTwy7EJBIsO1b.fWY.PIs0MaxtH4ykr2waUaW8ZZV.")
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/AddStudent").hasRole("ADMIN")
		.antMatchers("/delete").hasRole("ADMIN")
		.antMatchers("/update").hasRole("ADMIN")
		.antMatchers("/save").hasRole("ADMIN")
		.antMatchers("/list").hasAnyRole("USER", "ADMIN")
		.antMatchers("/save").hasAnyRole("USER", "ADMIN")
		.and().formLogin();
	}
	

}
