package com.epam.te.task3.client;

import java.util.Random;

import org.apache.log4j.Logger;

import com.epam.te.task3.callcenter.CallCenter;
import com.epam.te.task3.callcenter.Operator;
import com.epam.te.task3.exception.CallCenterException;

public class Client implements Runnable{
	private final static Logger logger = Logger.getLogger(Client.class);
	
	private int phoneNumber;
	private CallCenter callCenter;
	private volatile boolean stopThread = false;
	
	public Client(int number, CallCenter callCenter){
		this.phoneNumber = number;
		this.callCenter = callCenter;		
	}
	
	public void run(){
		try{
			while (!stopThread){
				logger.info("Клиент с тел. номером: " + this.phoneNumber + " звонит в центр...");
				callToCenter();
			}
		} catch (InterruptedException e){
			e.printStackTrace();
			logger.error("Клиент с тел. номером: " + this.phoneNumber + ", связь оборвана...", e);
		} catch (CallCenterException e){
			e.printStackTrace();
			logger.error("Клиенту с тел. номером: " + this.phoneNumber + " отказано в соединении...", e);
		}
	}
	
	
	// Звонок в CallCenter - получить оператор либо стать в очередь и ожидать свободного оператора.
	public void callToCenter() throws CallCenterException, InterruptedException{
		int callDuration = 0;
		Operator operator = null;
		
		boolean isLockedOperator = false;	// удалось ли заблокировать оператора
		boolean isCallSettedToQueue = false; // добавлен ли звонок в очередь ожидания
		
		try{	
			isLockedOperator = callCenter.lockOperator(this);
			if(isLockedOperator){
				operator = callCenter.getOperator(this);
				if (operator != null){
					callDuration = callDuration();
					logger.info("Клиент с тел. номером: " + this.phoneNumber + " дозвонился оператору-" + operator.getOperatorId() +".");	
					operator.using(callDuration);
				}
			}else{
				// если нет свободного оператора - стать в очередь звонков
				isCallSettedToQueue =  callCenter.setCallToQueue(this);
				if (isCallSettedToQueue){
					logger.info("Клиент с тел. номером: " + this.phoneNumber + " стоит в очереди к оператору.");
					clientAction();
				}
			}
		}finally{
			if(isLockedOperator && operator != null){
				callCenter.unlockOperator(this);
				stopThread = true;
				logger.info("Клиент с тел. номер: " + this.phoneNumber + "  завершил разговор с оператором  " + operator.getOperatorId()+
						  ". Длительность разговора: " + callDuration);
			}
		}
	}
	
	// Клиент, стоящий в очереди, может положить трубку.
	public void  finishCall(){
		if (this.callCenter.getCallQueue().contains(this)){
			callCenter.getCallQueue().remove(this);	
			stopThread = true;
		}
		logger.info("Клиент с тел. номер: " + this.phoneNumber + "  положил трубку.");
	}
	
	public int getNumber(){
		return this.phoneNumber;
	}

	private int callDuration() {
		Random random = new Random();
		int callDuration = random.nextInt(300) + 400;
		return callDuration;
	}
	
	
	/* Клиент, стоящий в очереди, может положить трубку 
	 * и перезвонить еще раз через некоторое время.
	 */
	private void clientAction() throws CallCenterException, InterruptedException{
		Random random = new Random();
		int value = random.nextInt(1000);
		
		if(value < 500){
			finishCall();
			if (value < 250){
				logger.info("Клиент с тел. номером: " + this.phoneNumber + " решил перезвонить в центр. Звонит...");
				callToCenter();
			}		
		}
		else {	
			callCenter.removeCallFromQueue(this);
			callToCenter();
		}
	}
	
	
	public void stopThread() {
		stopThread = true;
	}

}
