package com.epam.te.task05.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.epam.te.task05.logic.impl.DoDomCommand;
import com.epam.te.task05.logic.impl.DoSaxCommand;
import com.epam.te.task05.logic.impl.DoStaxCommand;
import com.epam.te.task05.logic.impl.NoSuchCommand;

public final class CommandHelper {
	
	private static final  CommandHelper instance = new CommandHelper();
	
	private Map<CommandName, ICommand> commands = new HashMap<>();
	
	public static CommandHelper getInstance(){
		return instance;
	}
	
	public CommandHelper(){

			commands.put(CommandName.DO_SAX_PARSER, new DoSaxCommand());
			commands.put(CommandName.DO_STAX_PARSER, new DoStaxCommand());
			commands.put(CommandName.DO_DOM_PARSER, new DoDomCommand());
			commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());

	}
	 
	public ICommand getCommand(String commandName) throws InterruptedException{
		
			CommandName name = CommandName.valueOf(commandName.toUpperCase());
			ICommand command;
			
			if (ResourceLock.getReadLock().tryLock(30, TimeUnit.SECONDS)){
				try{
					if (null != name){
						command = commands.get(name);
					}else{
						command = commands.get(CommandName.NO_SUCH_COMMAND);
					}			
					return command;
				}finally{
					ResourceLock.getReadLock().unlock();
				}
			}else{
				return null;
			}
	}	
}
