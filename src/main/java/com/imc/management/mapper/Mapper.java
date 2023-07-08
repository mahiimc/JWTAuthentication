package com.imc.management.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.imc.management.dto.LoginDTO;
import com.imc.management.dto.RegisterDTO;
import com.imc.management.model.AppUser;



/**
 * The Class Mapper.
 */
@Component
public class Mapper {
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Map to user.
	 *
	 * @param dto the dto
	 * @return the app user
	 */
	public AppUser mapToUser(RegisterDTO dto) {
		
		return new  AppUser(dto.getEmail(), dto.getUsername(), passwordEncoder.encode(dto.getPassword()));
	}
	
	/**
	 * Map to register DTO.
	 *
	 * @param user the user
	 * @return the register DTO
	 */
	public RegisterDTO mapToRegisterDTO(AppUser user) {
		return RegisterDTO.builder().email(user.getEmail())
		.username(user.getUsername())
		.email(user.getEmail())
		.build();
	}
}
	
