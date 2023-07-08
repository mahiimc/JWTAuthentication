package com.imc.management.service;

import com.imc.management.exception.UserAlreadyExistsException;
import com.imc.management.exception.UserNotFoundException;
import com.imc.management.model.AppUser;

public interface UserService {

	/**
	 * Loads a user by their username.
	 *
	 * @param username The username of the user to load.
	 * @return The loaded user.
	 * @throws UserNotFoundException if no user is found with the specified username.
	 */
	
	AppUser loadUserByUserName(String username) throws UserNotFoundException;

	/**
	 * Loads a user by their email.
	 *
	 * @param email The email of the user to load.
	 * @return The loaded user.
	 * @throws UserNotFoundException if no user is found with the specified email.
	 */
	AppUser loadUserByEmail(String email) throws UserNotFoundException;
	
	
	/**
	 * Adds a new user to the system.
	 *
	 * @param user The user to be added.
	 * @return {@code true} if the user was successfully added, {@code false} otherwise.
	 * @throws UserAlreadyExistsException if a user with the same email or username already exists.
	 */
	Boolean addUser(AppUser user) throws UserAlreadyExistsException;
}
