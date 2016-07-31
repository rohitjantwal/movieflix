package io.egen.rest.exception;


public class MovieAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3805224813252666795L;

	public MovieAlreadyExistsException(String message) {
		super(message);	
	}
	
	public MovieAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}

