package com.imc.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imc.management.dto.AuthToken;
import com.imc.management.dto.LoginDTO;
import com.imc.management.dto.RegisterDTO;
import com.imc.management.handler.AuthenticationHandler;
import com.imc.management.mapper.Mapper;
import com.imc.management.model.AppUser;
import com.imc.management.service.UserService;

import jakarta.validation.Valid;



/**
 * The AuthController class is a Spring REST controller that handles authentication-related endpoints.
 * It is mapped to the "/auth/" base path.
 */


@RestController
@RequestMapping("/auth/")
public class AuthController {

	@Autowired
	private Mapper mapper;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationHandler authHandler;
	
	
	/**
	 * Registers a new user with the provided registration data.
	 *
	 * @param dto the RegisterDTO containing the user's registration information
	 * @return a ResponseEntity indicating the success or failure of the registration process
	 */

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO dto) {
		AppUser user = mapper.mapToUser(dto);
		boolean added = userService.addUser(user);
		return added ? ResponseEntity.status(HttpStatus.CREATED).body("Registered Successfully!")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
	}

	/**
	 * Authenticates the user with the provided login credentials.
	 *
	 * @param dto the LoginDTO containing the user's login credentials
	 * @return a ResponseEntity containing an authentication token if the login is successful, or an error response if the login fails
	 */
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto) {
		AuthToken token = authHandler.handle(dto);
		return token != null ? ResponseEntity.status(HttpStatus.OK).body(token)
				: ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Login Failed");
	}

}
