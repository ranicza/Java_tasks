package com.epam.te.task05.logic;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResourceLock{

	private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();	

	public static ReentrantReadWriteLock.ReadLock getReadLock(){
		return rwl.readLock();
	}
	
	public static ReentrantReadWriteLock.WriteLock getWrightLock(){
		return rwl.writeLock();
	}
}
