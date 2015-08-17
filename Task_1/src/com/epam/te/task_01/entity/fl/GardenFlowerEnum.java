package com.epam.te.task_01.entity.fl;

public enum GardenFlowerEnum {
	IRIS("blue", "summer"), PEONY("pink", "spring-autumn"),
	MARIGOLD("orange", "summer-autumn"), PETUNIA("lilac", "autumn");
	
	private final String color;
    private final String season;
    
	GardenFlowerEnum(String color, String season){
		this.color = color;
		this.season = season;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String getSeason(){
		return this.season;
	}
}
