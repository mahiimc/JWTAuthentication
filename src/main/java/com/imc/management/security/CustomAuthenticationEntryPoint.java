package com.imc.management.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomAuthenticationEntryPoint.
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Commence.
	 *
	 * @param request the request
	 * @param response the response
	 * @param authException the auth exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		String message = "You do not have sufficient previleges to access this resource";
		String status = HttpStatus.UNAUTHORIZED.toString();
		response.setContentType("application/json");
		response.setHeader("WWW-Authenticate", "Bearer");
		response.getWriter().format("{\"message\":\"%s\",\"status\":\"%s\"}",message,status);
	}

}
