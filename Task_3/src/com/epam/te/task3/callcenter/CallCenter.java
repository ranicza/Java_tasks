package com.epam.te.task3.callcenter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.epam.te.task3.client.Client;
import com.epam.te.task3.exception.CallCenterException;

/* CallCenter
 * В организации работает несколько операторов.
 * Оператор может обслуживать одновременно только одного клиента.
 * При отсутсвии свободных операторов CallCenter ставит звонки в очередь.
 * Клиент, стоящий в очереди, может положить трубку 
 * и перезвонить еще раз через некоторое время.
 */

public class CallCenter {
	
	private final static Logger logger = Logger.getLogger(CallCenter.class);
	
	private static BlockingQueue<Operator> operators; 
	private static BlockingQueue<Client> callQueue; // очередь из ожидающих звонков
	private Map<Client, Operator> busyOperators;  
	
	public CallCenter(int operatorAmount){
		callQueue = new LinkedBlockingQueue<Client>();    // создание очереди из звонков
		operators = new ArrayBlockingQueue<Operator>(operatorAmount);   // создание очереди из свободных операторов
		for (int i = 0; i < operatorAmount; i++) { 
			operators.add(new Operator(i+1));
		}
		busyOperators = new HashMap<Client, Operator>(); // хранит связь между клиентом и оператором  
		logger.info("CallCenter начал свою работу.");
	}
	
	public boolean lockOperator(Client client) throws InterruptedException { // блокировать оператора
		Operator operator;
		try {
			operator = operators.poll(100, TimeUnit.MILLISECONDS); // пытается получить свободного оператора
			if(operator != null){
				busyOperators.put(client, operator);
			}else{
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("Клиенту c тел. номером:\t" + client.getNumber() + "\t отказано в соединении.", e);
			return false;
		}		
		return true;
	}
	
	public boolean unlockOperator(Client client) {  // разблокировать оператора
		Operator operator = busyOperators.get(client);
		try {
			if (operator != null){
				operators.put(operator);
				busyOperators.remove(operator);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error(e);
			return false;
		}		
		return true;
	}
	
	public Operator getOperator(Client client) throws CallCenterException {
		Operator operator = busyOperators.get(client);
		if (operator == null){
			throw new CallCenterException("Try to use Operator without blocking.");
		}
		return operator;		
	}
	
	
	public boolean setCallToQueue(Client client) throws InterruptedException, CallCenterException{   // поставить звонок в очередь
		boolean result = false;
		if (client != null){
			callQueue.put(client);
			result = true;
			try{
				TimeUnit.MILLISECONDS.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		return result;	
	}
	
	public  void removeCallFromQueue(Client client){  // извлечь звонок из очереди
		if(callQueue.size() > 0){
			client = callQueue.poll();
		}		
	}
	
	public BlockingQueue<Client> getCallQueue(){   
		return callQueue;
	}

}
