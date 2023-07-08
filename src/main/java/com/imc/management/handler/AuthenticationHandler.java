package com.imc.management.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.imc.management.dto.AuthToken;
import com.imc.management.dto.LoginDTO;
import com.imc.management.utils.JWTUtils;

import jakarta.validation.ValidationException;


/**
 * The Class AuthenticationHandler.
 */
@Component
public class AuthenticationHandler {

	/** The authentication provider. */
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	/** The jwt utils. */
	@Autowired
	private JWTUtils jwtUtils;
	
	
	/**
	 * Handle.
	 *
	 * @param dto the dto
	 * @return the auth token
	 */
	public AuthToken handle(LoginDTO dto) {
		
		String username = dto.getUsername();
		if(StringUtils.isBlank(username)) {
			throw new ValidationException("Please provide either email or username");
		}
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(username, dto.getPassword());
		Authentication authenticate = authenticationProvider.authenticate(authentication);
		return jwtUtils.generateToken(authenticate);
	}
}
