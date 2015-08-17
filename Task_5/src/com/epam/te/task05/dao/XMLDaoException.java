package com.epam.te.task05.dao;

import com.epam.te.task05.exception.ProjectException;

public class XMLDaoException extends ProjectException{

	private static final long serialVersionUID = 1L;
	
	public  XMLDaoException(){
		super();
	}
	
	public XMLDaoException(String message){
		super(message);
	}
	
	public XMLDaoException( String message, Exception e) {
		super(message, e);
	}
	

}
