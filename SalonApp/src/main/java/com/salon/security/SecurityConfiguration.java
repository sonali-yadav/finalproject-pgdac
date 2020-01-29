package com.salon.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select user_id,password,master_pk,active_deactive from user_mapping where user_id=?")
		.authoritiesByUsernameQuery("select user_id,role,master_pk from user_mapping where user_id=?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/customer/new").hasRole("CUSTOMER")
		.antMatchers("/customer/save").hasRole("CUSTOMER")
		.antMatchers("/","/**").permitAll()
		.and()
		.formLogin();
		
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.OPTIONS, "/**")
//		.permitAll().anyRequest().authenticated()
//		.and()
//		.httpBasic();
		
		http.csrf().disable();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bulbasaur").password("bulbasaur").roles("ADMIN");
	}

}
