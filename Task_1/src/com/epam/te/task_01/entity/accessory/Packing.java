package com.epam.te.task_01.entity.accessory;

public class Packing extends Accessory{
	private String material;
	
	public Packing(){}
	
	public Packing(String name, String color, String material){
		super(name, color);
		this.material = material;
	}
	
	public void setMaterial(String material){
		this.material = material;
	}
	public String getMaterial(){
		return this.material;
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
	    Packing tmp = (Packing)ob;
	    if (!super.equals(tmp)){
	    	return false;
	    }
	    if (material == null){
	    	return (material == tmp.material);
	    }else{
	    	if (!material.equals(tmp.material)){
	    		return false;
	    	}
	    }
	    return true;
	 }
	
	public int hashCode() {
		   return (int)(super.hashCode() + 31*((material == null) ? 0 : material.hashCode()));
	   }
	
	public String toString(){
		return super.toString() + ", material: " + this.material;
	}
}
