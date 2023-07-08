package com.imc.management.exception;

/**
 * The Class UserAlreadyExistsException.
 */
public class UserAlreadyExistsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user already exists exception.
	 *
	 * @param message the message
	 */
	public UserAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new user already exists exception.
	 *
	 * @param e the e
	 */
	public UserAlreadyExistsException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new user already exists exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public UserAlreadyExistsException(String message, Throwable e) {
		super(message, e);
	}
}
