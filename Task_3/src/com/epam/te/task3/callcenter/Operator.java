package com.epam.te.task3.callcenter;

import org.apache.log4j.Logger;

public class Operator {
	private static Logger logger = Logger.getLogger(Operator.class);
	
	private int operatorId;
	
	public Operator(int id){
		this.operatorId = id;
	}
	
	public int getOperatorId(){
		return this.operatorId;
	}
	
	public void using(long usingTime) {   // Использование оператора
		try {
			Thread.sleep(usingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

}
