package com.epam.te.task3.exception;

public class CallCenterException extends Exception{

	private static final long serialVersionUID = -2331833103313090164L;

	public CallCenterException() {
		super();
	}
	public CallCenterException( String message, Throwable cause) {
		super(message, cause);
	}
	
	public CallCenterException(String message) {
		super(message);
	}
		
	public CallCenterException(Throwable cause) {
		super(cause);
	}
}
