package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason ="User not found!")
public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8164040708966049957L;
	
	public UserNotFoundException(String message) {
		super(message);	
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
