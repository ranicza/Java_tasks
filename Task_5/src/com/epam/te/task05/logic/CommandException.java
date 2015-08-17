package com.epam.te.task05.logic;

import com.epam.te.task05.exception.ProjectException;

public class CommandException extends ProjectException{

	private static final long serialVersionUID = 1L;
	
	public CommandException(){
		super();
	}
	
	public CommandException(String message){
		super(message);
	}
	
	public CommandException( String message, Exception e) {
		super(message, e);
	}

}
