package com.imc.management.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

/**
* The LoginDTO class represents the data transfer object for login information.
* It implements the Serializable interface.
*/

@Data
@Builder
public class LoginDTO implements Serializable {
	
	/**
	 * The serial version UID for serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The username for login.
	 */
	@Length(min = 6,max = 16)
	private String username;

	/**
	 * The password for login.
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
