package com.imc.management.dto;

import java.io.Serializable;

import lombok.Data;


/**
 * The ErrorResponse class represents an error response containing a message and status.
 * It utilizes Lombok's @Data annotation for automatic generation of getters, setters, equals, hashCode, and toString methods.
 */


@Data
public class ErrorResponse implements Serializable{
	
	/**
	 * The serial version UID for serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The error message.
	 */
	private String message;
	
	/**
	 * The status of the error.
	 */
	private String status;

}
