package io.egen.rest.exception;

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
