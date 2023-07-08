package com.imc.management.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.imc.management.filter.JWTFilter;
import com.imc.management.security.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		http
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable())
		.authorizeHttpRequests(
				auth ->  auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/swagger/**").authenticated()
				.requestMatchers("/user/**").hasAnyAuthority("USER","ADMIN")
				.requestMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				)
		.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint()))
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter(),UsernamePasswordAuthenticationFilter.class )
		.authenticationManager(authenticationManager());
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public JWTFilter jwtFilter() {
		return new JWTFilter();
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}

}
