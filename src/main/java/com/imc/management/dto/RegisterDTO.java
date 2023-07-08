package com.imc.management.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

/**
 * The RegisterDTO class represents the data transfer object for user registration information.
 * It implements the Serializable interface.
 * It utilizes Lombok's @Data and @Builder annotations for automatic generation of getters, setters, equals, hashCode, and builder methods.
 */

@Data
@Builder
public class RegisterDTO implements Serializable {
	
	/**
	 * The serial version UID for serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The email address for user registration.
	 * 
	 * Constraints:
	 * - Valid email format
	 */
	
	@Email
	private String email;
	
	/**
	 * The username for user registration.
	 * 
	 * Constraints:
	 * - Minimum length: 6 characters
	 * - Maximum length: 16 characters
	 */
	@Length(min = 6, max = 16)
	@Length(min = 6, max = 16)
	private String username;
	
	/**
	 * The password for user registration.
	 * 
	 * Constraints:
	 * - Minimum length: 8 characters
	 * - Maximum length: 32 characters
	 * - At least one lowercase letter, one uppercase letter, one digit, and one special character (@, $, !, %, *, ?, &)
	 */
	
	@Length(min = 8,max = 32)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
}
