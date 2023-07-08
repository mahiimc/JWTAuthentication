package com.imc.management.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.imc.management.exception.InvalidCredentialsException;
import com.imc.management.model.AppUser;
import com.imc.management.model.SecuredUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		SecuredUser userFromDataBase = (SecuredUser) userDetailsService.loadUserByUsername(userName);
		AppUser appUserFromDataBase = userFromDataBase.getUser();
		
		if(appUserFromDataBase == null) {
			
			throw new InvalidCredentialsException("Invalid Credentials.");
		}
		
		if(passwordEncoder.matches(password, appUserFromDataBase.getPassword())) {
			authentication =  new UsernamePasswordAuthenticationToken(userFromDataBase.getUsername(), 
					null,userFromDataBase.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return authentication;
		}
		throw new InvalidCredentialsException("Invalid credentials provided");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
