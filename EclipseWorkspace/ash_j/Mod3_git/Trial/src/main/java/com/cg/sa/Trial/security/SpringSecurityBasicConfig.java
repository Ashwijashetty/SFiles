package com.cg.sa.Trial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityBasicConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/swagger*").permitAll()
				.antMatchers(HttpMethod.GET, "/read-data").hasAnyRole("ADMIN","USER","ADMIN2")
				.antMatchers(HttpMethod.POST, "/create-data").hasAnyRole("ADMIN","ADMIN2").and().csrf().disable().headers()
				.frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin1").password("{noop}password").roles("ADMIN").and()
				.withUser("user1").password("{noop}password").roles("USER").and().withUser("admin2")
				.password("{noop}password").roles("ADMIN2");/*.and().withUser("ramashanker").password("{noop}password")
				.roles("ADMIN");*/
	}
}
