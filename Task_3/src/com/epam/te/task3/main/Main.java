package com.epam.te.task3.main;

import org.apache.log4j.PropertyConfigurator;

import com.epam.te.task3.callcenter.CallCenter;
import com.epam.te.task3.client.Client;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("src//resources//log4j.properties");
		
		CallCenter center = new CallCenter(3);
		
		Client client_01 = new Client(100, center);
		Client client_02 = new Client(200, center);
		Client client_03 = new Client(300, center);
		Client client_04 = new Client(400, center);
		Client client_05 = new Client(500, center);
		Client client_06 = new Client(600, center);
		
		new Thread(client_01).start();	
		new Thread(client_02).start();
		new Thread(client_03).start();
		new Thread(client_04).start();
		new Thread(client_05).start();
		new Thread(client_06).start();
		
		Thread.sleep(300);
				
		client_01.stopThread();
		client_02.stopThread();
		client_03.stopThread();
		client_04.stopThread();
		client_05.stopThread();
		client_06.stopThread();
	}
}
