package com.epam.te.task05.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.te.task05.dao.XMLDao;
import com.epam.te.task05.dao.XMLDaoException;
import com.epam.te.task05.entity.Tariff;

public final class SaxXmlDao  implements XMLDao{
	
	private final static SaxXmlDao instance = new SaxXmlDao();
	
	public static SaxXmlDao getInstance(){
		return instance;
	}
	
	public List<Tariff> parse(String resourceName) throws XMLDaoException, SAXException, IOException{
		
		 XMLReader reader = XMLReaderFactory.createXMLReader();
		 TariffSAXHandler handler = new TariffSAXHandler();		 
		 
		 reader.setContentHandler(handler); 
		 reader.parse(new InputSource(resourceName));   
	 
		 List<Tariff> tariffList = handler.getTariffList();

		 return tariffList;
	}
}
