package io.egen.rest.exception;


public class MovieNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5582885126380583533L;

	public MovieNotFoundException(String message) {
		super(message);	
	}
	
	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
