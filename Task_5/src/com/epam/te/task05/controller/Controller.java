package com.epam.te.task05.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.te.task05.logic.CommandException;
import com.epam.te.task05.logic.CommandHelper;
import com.epam.te.task05.logic.ICommand;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(Controller.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String commandName = request.getParameter(RequestParametrName.COMMAND_NAME);
		ICommand command = null;		
		String page = null;
		
		try{
			command = CommandHelper.getInstance().getCommand(commandName);
			if (command != null){
				page = command.execute(request);
				logger.info("parsed successfully");
			}			
		}catch (CommandException e){
			page = JspPageName.ERROR_PAGE;
			logger.error(e.getMessage());
		}catch (IOException e){
			page = JspPageName.ERROR_PAGE;
			logger.error(e.getMessage());
		}catch (InterruptedException e){
			page = JspPageName.ERROR_PAGE;
			logger.error(e.getMessage());
		}
		catch (Exception e){
			page = JspPageName.ERROR_PAGE;
			logger.error(e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null){
			dispatcher.forward(request, response);
		}
	}
	


}
