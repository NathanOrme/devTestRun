package com.capgemini.devtestrun.items;

import java.util.ArrayList;

public enum Items {
    COLA("COLA", 0.5, "cold", "drink"),
    COFFEE("COFFEE", 1, "hot", "drink"),
    CHEESESANDWICH("CHEESESW", 2, "cold", "food"),
    STEAKSANDWICH("STEAKSW", 4.5, "hot", "food");
    
    private String id;
    private ArrayList<String> properties = new ArrayList<String>();
    private double price;
    
    private Items(String id, double price, String... properties) {
        this.id = id;
        this.price = price;
        for (String property : properties) {
            this.properties.add(property);
        }
    }
    
    public static Items getById(String id){
    	for(Items item : Items.values()){
    		if(item.id.equalsIgnoreCase(id)){
    			return item;
    		}
    	}
    	return null;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
