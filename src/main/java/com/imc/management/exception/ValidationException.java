package com.imc.management.exception;

/**
 * The Class ValidationException.
 */
public class ValidationException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message the message
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param e the e
	 */
	public ValidationException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public ValidationException(String message, Throwable e) {
		super(message, e);
	}
}
