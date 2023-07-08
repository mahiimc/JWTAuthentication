package com.imc.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;


/**
 * The AuthToken class represents an authentication token with its associated details.
 * It is annotated with @JsonInclude to exclude null fields from JSON serialization.
 * It utilizes Lombok's @Data and @Builder annotations for automatic generation of getters, setters, equals, hashCode, and builder methods.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class AuthToken {

	/**
	 * The authentication token.
	 */
	private String token;
	/**
	 * The refresh token for obtaining a new authentication token.
	 * Reserved for future implementation
	 */
	private String refreshToken;
	
	
	/**
	 * The expiration date and time of the authentication token.
	 */
	private String expiresAt;
	
}
