package com.epam.te.task05.logic;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.xml.sax.SAXException;

public interface ICommand {
	//public final static String XML = "WEB-INF/property/xml/tariff.xml";
	public String execute(HttpServletRequest request) throws CommandException, SAXException, IOException;
}
