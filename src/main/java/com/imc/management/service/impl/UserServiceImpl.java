package com.imc.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imc.management.enums.ApplicationRoles;
import com.imc.management.exception.UserAlreadyExistsException;
import com.imc.management.model.AppUser;
import com.imc.management.model.Role;
import com.imc.management.repository.UserRepository;
import com.imc.management.service.RoleService;
import com.imc.management.service.UserService;

/**
 * @author Mahesh Chary
 * @version 1.0
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Override
	public AppUser loadUserByUserName(String username) {
		return this.userRepository.findUserByUsername(username);
	}

	@Override
	public AppUser loadUserByEmail(String email) {
		return this.userRepository.findUserByEmail(email);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see UserService#addUser
	 */

	@Override
	public Boolean addUser(AppUser user) throws UserAlreadyExistsException {

		AppUser existingUserByEmail = loadUserByEmail(user.getEmail());

		if (existingUserByEmail != null) {
			throw new UserAlreadyExistsException("User already exists with provided email ,"
					+ " Please try to login or click on forgot password to recover your password");
		}
		AppUser existingUserByUserName = loadUserByUserName(user.getUsername());

		if (existingUserByUserName != null) {
			throw new UserAlreadyExistsException("User already exists with provided username");
		}

		Role role = roleService.findRoleByName(ApplicationRoles.USER.toString());
		user.setRoles(List.of(role));
		AppUser newUser = this.userRepository.save(user);
		return newUser != null;
	}
}
