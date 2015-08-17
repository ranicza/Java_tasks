package com.epam.te.task_01.entity.bouquet;

import java.util.ArrayList;

import com.epam.te.task_01.entity.accessory.Accessory;
import com.epam.te.task_01.entity.accessory.Lace;
import com.epam.te.task_01.entity.accessory.Packing;
import com.epam.te.task_01.entity.fl.Flower;

public class Bouquet {
	private int bouquetSize;
	
	private ArrayList<Flower> flowerList = new ArrayList<Flower>();
	private ArrayList<Accessory> accessoryList = new ArrayList<Accessory>();
	
	public Bouquet(){}
	
	public void addFlower(Flower f){
		flowerList.add(f);
	}
	
	public void removeFlower(Flower f){
		if(flowerList.contains(f)){
			flowerList.remove(f);
		}
	}
	
	public Flower getFlowerByName(String f){
		Flower flowerName = null;
		for(Flower flower : flowerList){
			if(flower.getName().equalsIgnoreCase(f)){
				flowerName =  flower;
				return flowerName;
			}
		} return flowerName;
	}
	
	public void printBouquetArray(Bouquet b){
		for(Flower fl : b.getFlowerList()){
			System.out.println(fl.toString());
		}
	}
	
	public ArrayList<Flower> getFlowerList(){
		return this.flowerList;
	}
	
	public ArrayList<Accessory> getAccessoryList(){
		return this.accessoryList;
	}
	
	public int getBouquetSize(){
		return flowerList.size();
	}
	
	public void addLace(Lace lace){
		accessoryList.add(lace);
	}
	
	public void addPacking(Packing p){
		accessoryList.add(p);
	}
	
	public boolean equals(Object ob){
	    if (this == ob){
	    	return true;
	    }
	    if (ob == null) {
	    	return false;
	    }
	    if (this.getClass() != ob.getClass()){
	    	return false;
	    }
	    Bouquet tmp = (Bouquet)ob;
	    if (bouquetSize!= tmp.bouquetSize){
	    	return false;
	    }
	    if (!getAccessoryList().equals(tmp.getAccessoryList())){
	    	return false;
	    }
	    if (!getFlowerList().equals(tmp.getFlowerList())){
	    	return false;
	    }
	    return true;     
	}
	
	public int hashCode() {
	    return (int)(31 * bouquetSize + this.getFlowerList().hashCode());
	}
	
 	public String toString(){
		return getClass().getName() + " @bouquetSize: " + bouquetSize;
	}
}
