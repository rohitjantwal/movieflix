package io.egen.rest.exception;

public class CommentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 810315090296523654L;
	public CommentNotFoundException(String message){
		super(message);
	}
	public CommentNotFoundException(String message,Throwable cause){
		super(message,cause);
	}
}
