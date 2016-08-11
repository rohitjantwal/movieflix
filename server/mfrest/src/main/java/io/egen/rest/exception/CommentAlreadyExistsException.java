package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason ="Comment already exists!")
public class CommentAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 401424268996443526L;
	public CommentAlreadyExistsException (String message){
		super(message);
	}
	public CommentAlreadyExistsException (String message,Throwable cause){
		super(message,cause);
	}
}
