package com.epam.te.task05.controller;

import com.epam.te.task05.logic.ResourceProperty;

public final class JspPageName {
	public final static String USER = "user";
	public final static String ERROR = "error";
	
	private JspPageName() {}
	
	public static final String USER_PAGE = ResourceProperty.getPath(USER);
	
	public static final String ERROR_PAGE = ResourceProperty.getPath(ERROR);
}
