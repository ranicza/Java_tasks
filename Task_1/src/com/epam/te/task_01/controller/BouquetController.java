package com.epam.te.task_01.controller;

import java.util.List;
import java.util.Map;

import com.epam.te.task_01.entity.bouquet.Bouquet;
import com.epam.te.task_01.entity.fl.Flower;
import com.epam.te.task_01.logic.BouquetAction;

public class BouquetController {
	
	private BouquetAction action = new BouquetAction();
	
	public Bouquet execute(FlowerCommandName command){
        switch(command){
            case CREATE_NEW_BOUQUET:
                return action.createBouquet();
            default:  throw new IllegalArgumentException();
        }
   }
	
	public Bouquet execute(FlowerCommandName command, Bouquet bouquet, String flower_name, int quantity){	
        switch(command){  
	        case DELETE_FLOWER:
	        	return action.deleteFlower(bouquet, flower_name, quantity);
	        case SORT_FLOWERS_BY_FRESHNESS:
	        	return action.sortFlower(bouquet);
	        default : throw new IllegalArgumentException();
        }       
	}
	
	public Bouquet execute(FlowerCommandName command, Bouquet bouquet, String flower_name, int length, int quantity){	
        switch(command){  
	        case ADD_FLOWER:
	 			return action.addNewFlower(bouquet, flower_name, length, quantity);
	        default : throw new IllegalArgumentException();
        }       
	}
	
   public Bouquet execute(FlowerCommandName command, Bouquet bouquet){
	   switch(command){
	   case SORT_FLOWERS_BY_FRESHNESS:
       		return action.sortFlower(bouquet);
       case GET_BOUQUET_COST:
    	   int cost = action.bouquetCost(bouquet);
    	   System.out.println(cost);
    	   return bouquet;
       default:  throw new IllegalArgumentException();
       }
   }
   
   public List<Flower> execute(FlowerCommandName command, Bouquet bouquet, int minLength, int maxLength){
	   switch(command){
	   case FIND_FLOWER_LENGTH:
       		return action.findFlowerLength(bouquet, minLength, maxLength);
       default:  throw new IllegalArgumentException();
       }
   }  
   
   public Bouquet execute(FlowerCommandName command, Bouquet bouquet, int cutLength){
	   switch(command){
	   case CUT_ONE_LENGTH:
       		return action.cutOneLength(bouquet,cutLength);
       default:  throw new IllegalArgumentException();
       }
   }
   
   public Bouquet execute(FlowerCommandName command, Bouquet bouquet, String name, String color, int length){
	   switch(command){
	   case ADD_LACE:
       		return action.addLace(bouquet, name, color, length);
       default:  throw new IllegalArgumentException();
       }
   }
   
   public Bouquet execute(FlowerCommandName command, Bouquet bouquet, String name, String color, String material){
	   switch(command){
	   case ADD_PACKING:
       		return action.addPacking(bouquet, name, color, material);
       default:  throw new IllegalArgumentException();
       }
   }
  
}
