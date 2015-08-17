package com.epam.te.task_01.entity.accessory;

public class Lace extends Accessory{
private int length;
	
	public Lace(){}

	public Lace(String name, String color, int length){
		super(name, color);
		this.length = length;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	public int getLength(){
		return this.length;
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
	    Lace tmp = (Lace)ob;
	    if (!super.equals(tmp)){
	    	return false;
	    }
	    if (length!= tmp.length){
	    	return false;
	    }
	    return true;
	 }
		
	public int hashCode() {
		   return (int)(super.hashCode() + 97*length);
	   }
	
	public String toString(){
		return super.toString() + ", length: " + this.length;
	}
}
