package com.epam.te.task_01.entity.fl;

import java.util.Random;

public enum Freshness {
	FRESH, MIDDLE, OLD;
	
	public static Freshness getMyFreshness(){
		Freshness[] fresh = Freshness.values();
		Random rand = new Random();
		return fresh[rand.nextInt(fresh.length)];
	}
}
