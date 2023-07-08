package com.imc.management.exception;

/**
 * The Class InvalidCredentialsException.
 */
public class InvalidCredentialsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new invalid credentials exception.
	 *
	 * @param message the message
	 */
	public InvalidCredentialsException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid credentials exception.
	 *
	 * @param e the e
	 */
	public InvalidCredentialsException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new invalid credentials exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public InvalidCredentialsException(String message, Throwable e) {
		super(message, e);
	}
}
