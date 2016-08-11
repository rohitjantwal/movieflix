package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason ="Movie not found!")
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
