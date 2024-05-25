package com.app.registrationservice.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
//	@Bean
//	SecurityFilterChain web(HttpSecurity http) throws Exception {
//		http
//
//				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/", "/registration/userRegister")
//						.permitAll().anyRequest().authenticated())
//				.csrf(csrf -> csrf.disable());
//
//		return http.build();
//	}

}
