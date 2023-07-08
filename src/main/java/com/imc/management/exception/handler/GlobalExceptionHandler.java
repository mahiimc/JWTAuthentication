package com.imc.management.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.imc.management.dto.ErrorResponse;
import com.imc.management.exception.AppException;
import com.imc.management.exception.InvalidCredentialsException;
import com.imc.management.exception.InvalidTokenException;
import com.imc.management.exception.UserAlreadyExistsException;
import com.imc.management.exception.UserNotFoundException;



/**
 * The Class GlobalExceptionHandler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle inavlid token exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = {InvalidTokenException.class, InvalidCredentialsException.class})
	protected ResponseEntity<ErrorResponse> handleInavlidTokenException(RuntimeException ex, WebRequest request) {
		
		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.UNAUTHORIZED.toString());
		return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	
	/**
	 * Handle user alreadt exists exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = {UserAlreadyExistsException.class,UserNotFoundException.class})
	protected ResponseEntity<ErrorResponse> handleUserAlreadtExistsException(RuntimeException ex, WebRequest request) {
		
		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.toString());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	/**
	 * Handle app exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = {AppException.class})
	protected ResponseEntity<ErrorResponse> handleAppException(RuntimeException ex, WebRequest request) {
		
		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
