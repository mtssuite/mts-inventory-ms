/*
 * Created on 27-Nov-2020
 * Created by murugan
 * Copyright � 2020 MTS [murugan425]. All Rights Reserved.
 */
package com.tamil.mts.mtsinventoryms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author murugan
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorize -> {
			authorize.antMatchers("/").permitAll()
					// Providing access to contact resources GET without authentication.
					.antMatchers(HttpMethod.GET, "/mts/api/v1/contact/*").permitAll();
		}).authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	}

}
