package com.imc.management.exception;

/**
 * The Class AppException.
 */
public class AppException extends RuntimeException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 *
	 * @param message the message
	 */
	public AppException(String message) {
		super(message);
	}

	
	
	/**
	 * Instantiates a new app exception.
	 *
	 * @param e the e
	 */
	public AppException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 *
	 * @param message the message
	 * @param e the throwable
	 */
	public AppException(String message, Throwable e) {
		super(message, e);
	}
}
