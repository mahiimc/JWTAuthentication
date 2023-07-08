package com.imc.management.exception;

/**
 * The Class InvalidTokenException.
 */
public class InvalidTokenException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new invalid token exception.
	 *
	 * @param message the message
	 */
	public InvalidTokenException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid token exception.
	 *
	 * @param e the e
	 */
	public InvalidTokenException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new invalid token exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public InvalidTokenException(String message, Throwable e) {
		super(message, e);
	}
}
