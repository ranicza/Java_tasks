package com.epam.te.task_01.logic;

import com.epam.te.task_01.entity.fl.Flower;
import com.epam.te.task_01.entity.fl.GardenFlower;
import com.epam.te.task_01.entity.fl.GreenhouseFlower;

//the factory creates  flower
public class FlowerFactory {
	
	public static Flower createFlower(String type, int length){
		switch(type.toUpperCase()){
			case "IRIS":
				return new GardenFlower("IRIS", length);
			case "PEONY":
				return new GardenFlower("PEONY", length);
			case "MARIGOLD":
				return new GardenFlower("MARIGOLD", length);
			case "PETUNIA":
				return new GardenFlower("PETUNIA", length);
			case "ROSE":
				return new GreenhouseFlower("ROSE", length);
			case "CHRISANTEMUM":
				return new GreenhouseFlower("CHRISANTEMUM", length);
			case "LILY":
				return new GreenhouseFlower("LILY", length);
			default: throw new IllegalArgumentException();
		}
	}
}


//------------------------------------------------------------------
//public static Flower createFlower(String type){
//	
//	private GarFlowerEnum[] garden = GarFlowerEnum.values();
//	private HouseFlowerEnum[] house = HouseFlowerEnum.values();
//	private String flowerType =  null;
//	
//	try{
//	   if (GarFlowerEnum.valueOf(type.toUpperCase()) != null ) {
//		   flowerType = "Garden";
//		   return new GardenFlower(type.toUpperCase());
//	   }
//	  
//	} catch (IllegalArgumentException e){ 
//		System.out.println("It's not a garden flower");
//	}
//	try{
//		if (flowerType == null) {
//			if (HouseFlowerEnum.valueOf(type.toUpperCase()) != null){
//				flowerType= "House";
//				return new GreenhouseFlower(type.toUpperCase());
//			}
//		}
//	}catch (IllegalArgumentException e){
//		System.out.println("It's not a greenhouse flower");
//	}
//	if (flowerType == null) {
//		System.out.println("We were unable to determine type of flower you inputed, please verify a flower you specified!");
//	}
//	return null;
//}	