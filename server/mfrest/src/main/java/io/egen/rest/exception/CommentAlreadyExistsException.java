package io.egen.rest.exception;

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
