package com.epam.te.task05.logic.impl;

import javax.servlet.http.HttpServletRequest;

import com.epam.te.task05.controller.JspPageName;
import com.epam.te.task05.logic.CommandException;
import com.epam.te.task05.logic.ICommand;

public class NoSuchCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		return JspPageName.ERROR_PAGE;
		
	}
}
