package com.epam.te.task_01.entity.fl;

public class GardenFlower extends Flower{
	private String seasonality; 
	
	public GardenFlower(String name, int length){
		super(name, length);
		super.setColor(GardenFlowerEnum.valueOf(name.toUpperCase()).getColor());
		this.seasonality = GardenFlowerEnum.valueOf(name.toUpperCase()).getSeason();
	}
	
	public String getSeasonality(){
		return this.seasonality;
	}
	
	public boolean equals (Object ob){
	    if (this == ob) {
	    	return true;
	    }
	    if (ob == null) {
	    	return false;
	    }
	    if (this.getClass() != ob.getClass()){
	    	return false;
	    }
	    GardenFlower tmp = (GardenFlower)ob;
	    if (!super.equals(tmp)){
	    	return false;
	    }
	    if (seasonality == null){
	    	return (seasonality == tmp.seasonality);
	    }else{
	    	if (!seasonality.equals(tmp.seasonality)){
	    		return false;
	    	}
	    }
	    return true;
	 }
	
	public int hashCode() {
		   return (int)(super.hashCode() + ((seasonality == null) ? 0 : seasonality.hashCode()));
	}
	
	public String toString(){
		return super.toString() + ", seasonality: " + this.getSeasonality();
	}
}
