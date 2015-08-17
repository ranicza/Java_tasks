package com.epam.te.task05.logic;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProperty {
	private final static String PATH = "property.path";
	private final static String XML = "xml";
	
	private final static ResourceBundle bundle = ResourceBundle.getBundle(PATH, Locale.ENGLISH);	
	
	public static String getPath(String key){
		return bundle.getString(key);
	}
	
	public static String getPathToXML(){
		return bundle.getString(XML);
	}
}
