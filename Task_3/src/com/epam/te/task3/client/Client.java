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
				logger.info("������ � ���. �������: " + this.phoneNumber + " ������ � �����...");
				callToCenter();
			}
		} catch (InterruptedException e){
			e.printStackTrace();
			logger.error("������ � ���. �������: " + this.phoneNumber + ", ����� ��������...", e);
		} catch (CallCenterException e){
			e.printStackTrace();
			logger.error("������� � ���. �������: " + this.phoneNumber + " �������� � ����������...", e);
		}
	}
	
	
	// ������ � CallCenter - �������� �������� ���� ����� � ������� � ������� ���������� ���������.
	public void callToCenter() throws CallCenterException, InterruptedException{
		int callDuration = 0;
		Operator operator = null;
		
		boolean isLockedOperator = false;	// ������� �� ������������� ���������
		boolean isCallSettedToQueue = false; // �������� �� ������ � ������� ��������
		
		try{	
			isLockedOperator = callCenter.lockOperator(this);
			if(isLockedOperator){
				operator = callCenter.getOperator(this);
				if (operator != null){
					callDuration = callDuration();
					logger.info("������ � ���. �������: " + this.phoneNumber + " ���������� ���������-" + operator.getOperatorId() +".");	
					operator.using(callDuration);
				}
			}else{
				// ���� ��� ���������� ��������� - ����� � ������� �������
				isCallSettedToQueue =  callCenter.setCallToQueue(this);
				if (isCallSettedToQueue){
					logger.info("������ � ���. �������: " + this.phoneNumber + " ����� � ������� � ���������.");
					clientAction();
				}
			}
		}finally{
			if(isLockedOperator && operator != null){
				callCenter.unlockOperator(this);
				stopThread = true;
				logger.info("������ � ���. �����: " + this.phoneNumber + "  �������� �������� � ����������  " + operator.getOperatorId()+
						  ". ������������ ���������: " + callDuration);
			}
		}
	}
	
	// ������, ������� � �������, ����� �������� ������.
	public void  finishCall(){
		if (this.callCenter.getCallQueue().contains(this)){
			callCenter.getCallQueue().remove(this);	
			stopThread = true;
		}
		logger.info("������ � ���. �����: " + this.phoneNumber + "  ������� ������.");
	}
	
	public int getNumber(){
		return this.phoneNumber;
	}

	private int callDuration() {
		Random random = new Random();
		int callDuration = random.nextInt(300) + 400;
		return callDuration;
	}
	
	
	/* ������, ������� � �������, ����� �������� ������ 
	 * � ����������� ��� ��� ����� ��������� �����.
	 */
	private void clientAction() throws CallCenterException, InterruptedException{
		Random random = new Random();
		int value = random.nextInt(1000);
		
		if(value < 500){
			finishCall();
			if (value < 250){
				logger.info("������ � ���. �������: " + this.phoneNumber + " ����� ����������� � �����. ������...");
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
