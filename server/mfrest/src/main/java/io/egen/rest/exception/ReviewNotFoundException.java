package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason ="Review not found!")
public class ReviewNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2085425882485706900L;
	public ReviewNotFoundException(String message){
		super(message);
	}
	public ReviewNotFoundException(String message,Throwable cause){
		super(message,cause);
	}
}
