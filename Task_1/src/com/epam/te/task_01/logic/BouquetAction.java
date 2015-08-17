package com.epam.te.task_01.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.epam.te.task_01.entity.bouquet.Bouquet;
import com.epam.te.task_01.entity.fl.Flower;

public class BouquetAction {
	public static final String 	IRIS = "IRIS";
	public static final String 	CHRISANTEMUM = "CHRISANTEMUM";
	public static final String 	ROSE = "ROSE";
	public static final String 	LILY = "LILY";
	
	public Bouquet createBouquet(){
		return new Bouquet();
	}
	
	public Bouquet addNewFlower(Bouquet bouquet, String flower, int length, int number){
		for (int i = 0; i < number; i++){
			bouquet.addFlower(FlowerFactory.createFlower(flower, length));
		}
		return bouquet;
	}
	
	public Bouquet deleteFlower(Bouquet bouquet, String flower, int number){
		for (int i = 0; i < number; i++){
			bouquet.removeFlower(bouquet.getFlowerByName(flower));
		}
		return bouquet;
	}
	
	public Bouquet addLace(Bouquet bouquet, String name, String color, int length){
		bouquet.addLace(AccessoryFactory.createLace(name, color, length));
		return bouquet;
	}
	
	public Bouquet addPacking(Bouquet bouquet, String name, String color, String material){
		bouquet.addPacking(AccessoryFactory.createPacking(name, color, material));
		return bouquet;
	}
	
	public int bouquetCost(Bouquet b){
		int cost = 0;
		ArrayList<Flower> flowerList = b.getFlowerList();
		for(Flower fl: flowerList){
			switch(fl.getFreshness()){
				case FRESH:
					cost += 15;
					break;
				case MIDDLE:
					cost += 10;
					break;
				case OLD:
					cost += 5;
					break;
			}if(fl.getName() == IRIS || fl.getName() == CHRISANTEMUM){
	
				cost += 27;
			}else if(fl.getName() == ROSE || fl.getName() == LILY){
				
				cost += 35;
			}else {
				cost += 23;
			}
			if(fl.getLength() >= 60 && fl.getLength() <= 70){
				cost += 30;
			}else if(fl.getLength() < 60 && fl.getLength() >= 50){
				cost += 20;
			}else{
				cost += 10;
			}
		}
		return cost;
	}
	
	public List<Flower> findFlowerLength(Bouquet b, int minLength, int maxLength){
		if (maxLength > minLength && minLength	> 0 ){
			List<Flower> foundFlowers = new ArrayList<>();
			for(Flower fl: b.getFlowerList()){
				if (fl.getLength() >= minLength && fl.getLength() <= maxLength) {
						foundFlowers.add(fl);
						System.out.println(fl);
				}
			}
			return foundFlowers;
		}else{
			return null;
		}
	}
	
	// Sort flowers in bouquet according it's freshness
	private Comparator<Flower> flowerComparator = new Comparator<Flower>() {
		 
        @Override
        public int compare(Flower f1, Flower f2) {
            return (int) (f1.getTotalFresh() - f2.getTotalFresh());
        }
   };
	
	public Bouquet sortFlower(Bouquet bouquet){
		Collections.sort(bouquet.getFlowerList(), flowerComparator);
		bouquet.printBouquetArray(bouquet);
		return bouquet;
	}
	
		
	// Cut flowers to one length 
	public Bouquet cutOneLength(Bouquet bouquet, int length){
		if(length >= 20){
			for(Flower fl : bouquet.getFlowerList()){
				fl.setLength(length);
			}
			bouquet.printBouquetArray(bouquet);
		}
		
		return bouquet;
	}
	

	
}
