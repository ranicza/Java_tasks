package com.epam.te.task05.exception;

public class ProjectException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ProjectException(){
		super();
	}
	
	public ProjectException(String message){
		super(message);
	}
	
	public ProjectException( String message, Exception e) {
		super(message, e);
	}

}
