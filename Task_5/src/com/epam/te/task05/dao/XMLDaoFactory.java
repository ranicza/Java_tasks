package com.epam.te.task05.dao;

import com.epam.te.task05.dao.impl.DomXmlDao;
import com.epam.te.task05.dao.impl.SaxXmlDao;
import com.epam.te.task05.dao.impl.StaxXmlDao;

public class XMLDaoFactory {
	
	private final static XMLDaoFactory instance = new XMLDaoFactory();
	
	public static XMLDaoFactory getInstance(){
		return instance;
	}
	
	public XMLDao getDAO(DAOType type) throws XMLDaoException{
		switch(type){
		case SAX:
			return SaxXmlDao.getInstance();
		case STAX:
			return StaxXmlDao.getInstance();
		case DOM:
			return DomXmlDao.getInstance();
		default:
			throw new XMLDaoException("No such DAO");
		}
	}
	
	public enum DAOType{
		SAX, DOM, STAX
	}
}
