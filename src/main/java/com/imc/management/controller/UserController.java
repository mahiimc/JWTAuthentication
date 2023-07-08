package com.imc.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imc.management.exception.AppException;


/**
 * The UserController class is a Spring REST controller that handles user-related endpoints.
 * It is mapped to the "/user/" base path.
 */

@RestController
@RequestMapping("/user/")
public class UserController {
	
	
	/**
	 * Retrieves a welcome message for the logged-in user.
	 *
	 * @return a ResponseEntity containing the welcome message if the user is authenticated, or an error response if authentication fails
	 * @throws AppException if something goes wrong during the processing
	 */

	@GetMapping("/welcome")
	public ResponseEntity<?> greetLoggedInUser() throws AppException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Welcome " + authentication.getName());
		}
		throw new AppException("Somethig went wrong!");
	}
}
