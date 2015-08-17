package com.epam.te.task_01.logic;

import com.epam.te.task_01.entity.accessory.Accessory;
import com.epam.te.task_01.entity.accessory.AccessoryEnum;
import com.epam.te.task_01.entity.accessory.Lace;
import com.epam.te.task_01.entity.accessory.Packing;

//the factory creates  accessory
public class AccessoryFactory {
	
	public static Lace createLace(String name, String color, int length){
		return new Lace(name, color, length);
	}
	
	public static Packing createPacking(String name, String color, String material){
		return new Packing(name, color, material);
	}
	
//	public static Accessory createAccessory(AccessoryEnum accessoryType){
//	switch(accessoryType){
//		case LACE:
//			return new Lace();
//		case PACKING:
//			return new Packing();
//	}
//	
//}
}
