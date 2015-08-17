package com.epam.te.task_02.exception;

public class ParseException extends Exception {
	
	private static final long serialVersionUID = -7332731694152776511L;

	public ParseException() {
		super();
	}
	public ParseException( String message, Throwable cause) {
		super(message, cause);
	}
	
	public ParseException(String message) {
		super(message);
	}
		
	public ParseException(Throwable cause) {
		super(cause);
	}
}
