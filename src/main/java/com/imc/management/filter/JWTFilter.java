package com.imc.management.filter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.imc.management.utils.JWTUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * The Class JWTFilter.
 */
public class JWTFilter extends OncePerRequestFilter {
	
	/** The jwt utils. */
	@Autowired
	private JWTUtils jwtUtils;

	/**
	 * Do filter internal.
	 *
	 * @param request the request
	 * @param response the response
	 * @param filterChain the filter chain
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if(StringUtils.isNotBlank(token) &&  !jwtUtils.validateToken(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return ;
		}
		filterChain.doFilter(request, response);
	}
	
	/**
	 * Gets the token.
	 *
	 * @param request the request
	 * @return the token
	 */
	private String  getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if((header != null && !"".equals(header)) && header.contains("Bearer ") ) {
			return  header.substring(7);
		}
		return "";
	}	

}
