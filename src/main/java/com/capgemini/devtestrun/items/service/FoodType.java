package com.capgemini.devtestrun.items.service;

import java.util.ArrayList;

public enum FoodType {

	FREE("cold", "food"),
    COLD_FOOD("cold", "food"),
    HOT_FOOD("hot", "food");
    
    private ArrayList< String> types = new ArrayList<String>();
    
    /**
     * Searches through the number
     * of strings passed through the method
     * and adds them to the array.
     * @param triggers
     */
    private FoodType(String... fTypes) {
        for (String type : fTypes) {
        	types.add(type);
        }
    }
    
    public boolean triggeredBy(ArrayList<String> fTypes) {
        boolean found = false;
        for (String type : fTypes) {
            if(types.contains(type)){
            	found = true;
            } else {
            	found = false;
                return found;
            }
        }
        return found;
    }
	
}