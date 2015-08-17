package com.epam.te.task05.entity;

public class Tariff {
	// XML fields
		private String id;
	    private String name;
	    private Operator operatorName;
	    private double payroll;
	    private double priceInsideNetwork;
	    private double priceOutsideNetwork;
	    private double priceStationaryNetwork;
	    private double smsPrice;
	    private int favouriteNumber;
	    private Tariffing tariffing;
	    private double priceForConnection;
	    
	    
	    public Tariff(){}
	    
	    /**
	     * Initializes Tariff object.
	     *
	     * @param name
	     * @param operator_name
	     * @param payroll
	     * @param price_inside_network
	     * @param price_outside_network
	     * @param price_stationary_network
	     * @param sms_price
	     * @param favourite_number
	     * @param tarrifing
	     * @param price_for_connection
	     */
	    public Tariff(String id, String name, Operator operator_name, double payroll, double price_inside_network, 
	    		double price_outside_network, double price_stationary_network, double sms_price, int favourite_number,
	            Tariffing tariffing, double price_for_connection) {
	    	this.id = id;
	        this.name = name;
	        this.operatorName = operator_name;
	        this.payroll = payroll;
	        this.priceInsideNetwork = price_inside_network;
	        this.priceOutsideNetwork = price_outside_network;
	        this.priceStationaryNetwork = price_stationary_network;
	        this.smsPrice = sms_price;
	        this.favouriteNumber = favourite_number;
	        this.tariffing = tariffing;
	        this.priceForConnection = price_for_connection;     
	    }
	 
	    public String getId() {
	        return this.id;
	    }
	    
	    public void setId(String id){
	    	this.id = id;
	    }
	    
	    public String getName() {
	        return this.name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public Operator getOperatorName() {
	        return this.operatorName;
	    }
	    
	    public void setOperatorName(Operator name) {
	        this.operatorName = name;
	    }
	    
	    public double getPayroll() {
	        return this.payroll;
	    }
	    
	    public void setPayroll(double payroll) {
	        this.payroll = payroll;
	    }
	    
	    public double getPriceInsideNetwork() {
	        return this.priceInsideNetwork;
	    }
	    
	    public void setPriceInsideNetwork(double price_inside_network) {
	        this.priceInsideNetwork = price_inside_network;
	    }
	    
	    public double getPriceOutsideNetwork() {
	        return this.priceOutsideNetwork;
	    }
	    
	    public void setPriceOutsideNetwork(double price_outside_network) {
	        this.priceOutsideNetwork = price_outside_network;
	    }
	    
	    public double getPriceStationaryNetwork() {
	        return this.priceStationaryNetwork;
	    }
	    
	    public void setPriceStationaryNetwork(double price_stationary_network) {
	        this.priceStationaryNetwork = price_stationary_network;
	    }
	    
	    public double getSmsPrice() {
	        return this.smsPrice;
	    }
	    
	    public void setSmsPrice(double sms_price) {
	        this.smsPrice = sms_price;
	    }
	    
	    public int getFavouriteNumber(){
	    	return this.favouriteNumber;
	    }
	    
	    public void setFavouriteNumber(int number){
	    	this.favouriteNumber = number;
	    }
	    
	    public Tariffing getTariffing() {
	        return this.tariffing;
	    }
	    
	    public void setTariffing(Tariffing tariffing) {
	    	this.tariffing = tariffing;
	    }
	    
	    public double getPriceForConnection() {
	        return this.priceForConnection;
	    }
	    
	    public void setPriceForConnection(double price) {
	        this.priceForConnection = price;
	    }

}
