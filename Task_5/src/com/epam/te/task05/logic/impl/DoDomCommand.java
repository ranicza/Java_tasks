package com.epam.te.task05.logic.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.xml.sax.SAXException;

import com.epam.te.task05.controller.JspPageName;
import com.epam.te.task05.controller.RequestParametrName;
import com.epam.te.task05.dao.XMLDao;
import com.epam.te.task05.dao.XMLDaoException;
import com.epam.te.task05.dao.XMLDaoFactory;
import com.epam.te.task05.entity.Tariff;
import com.epam.te.task05.logic.CommandException;
import com.epam.te.task05.logic.ICommand;
import com.epam.te.task05.logic.ResourceProperty;

public class DoDomCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException, SAXException, IOException{
		
		String page = null;
		XMLDao dao = null;
		
		try{
			dao = XMLDaoFactory.getInstance().getDAO(XMLDaoFactory.DAOType.DOM);

			List<Tariff> info = dao.parse(request.getServletContext().getRealPath(ResourceProperty.getPathToXML()));
 
			request.setAttribute(RequestParametrName.SIMPLE_INFO, info);
			page = JspPageName.USER_PAGE;
			
		}catch(XMLDaoException e){
			throw new CommandException("Can't get dao", e);
		}
		
		return page;
		
	}
}
