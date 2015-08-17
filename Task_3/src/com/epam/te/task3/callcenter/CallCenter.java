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
 * � ����������� �������� ��������� ����������.
 * �������� ����� ����������� ������������ ������ ������ �������.
 * ��� ��������� ��������� ���������� CallCenter ������ ������ � �������.
 * ������, ������� � �������, ����� �������� ������ 
 * � ����������� ��� ��� ����� ��������� �����.
 */

public class CallCenter {
	
	private final static Logger logger = Logger.getLogger(CallCenter.class);
	
	private static BlockingQueue<Operator> operators; 
	private static BlockingQueue<Client> callQueue; // ������� �� ��������� �������
	private Map<Client, Operator> busyOperators;  
	
	public CallCenter(int operatorAmount){
		callQueue = new LinkedBlockingQueue<Client>();    // �������� ������� �� �������
		operators = new ArrayBlockingQueue<Operator>(operatorAmount);   // �������� ������� �� ��������� ����������
		for (int i = 0; i < operatorAmount; i++) { 
			operators.add(new Operator(i+1));
		}
		busyOperators = new HashMap<Client, Operator>(); // ������ ����� ����� �������� � ����������  
		logger.info("CallCenter ����� ���� ������.");
	}
	
	public boolean lockOperator(Client client) throws InterruptedException { // ����������� ���������
		Operator operator;
		try {
			operator = operators.poll(100, TimeUnit.MILLISECONDS); // �������� �������� ���������� ���������
			if(operator != null){
				busyOperators.put(client, operator);
			}else{
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("������� c ���. �������:\t" + client.getNumber() + "\t �������� � ����������.", e);
			return false;
		}		
		return true;
	}
	
	public boolean unlockOperator(Client client) {  // �������������� ���������
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
	
	
	public boolean setCallToQueue(Client client) throws InterruptedException, CallCenterException{   // ��������� ������ � �������
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
	
	public  void removeCallFromQueue(Client client){  // ������� ������ �� �������
		if(callQueue.size() > 0){
			client = callQueue.poll();
		}		
	}
	
	public BlockingQueue<Client> getCallQueue(){   
		return callQueue;
	}

}
