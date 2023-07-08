package com.imc.management.exception;

/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param e the e
	 */
	public UserNotFoundException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public UserNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
