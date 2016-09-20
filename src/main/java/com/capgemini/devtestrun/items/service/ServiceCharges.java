package com.capgemini.devtestrun.items.service;

import java.util.ArrayList;

import com.capgemini.devtestrun.items.Items;

public enum ServiceCharges {
    FREE(0, 0, FoodType.FREE),
    TEN_PERCENT(10, 0, FoodType.COLD_FOOD),
    TWENTY_PERCENT(20, 20, FoodType.HOT_FOOD);
    
    private int percentage;
    private int limit;
    private ArrayList<FoodType> collectTypes = new ArrayList<FoodType>();
    private ServiceCharges(int percentage, int limit, FoodType... types) {
        this.percentage = percentage;
        this.limit = limit;
        
        for (FoodType type : types) {
            collectTypes.add(type);
        }
    }

    public int getLimit() {
        return limit;
    }
    
    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public ArrayList<FoodType> getFoodTypes() {
        return collectTypes;
    }

    public void setFoodTypes(ArrayList<FoodType> foodtypes) {
        collectTypes = foodtypes;
    }
    
    public ServiceCharges checkServiceCharge(Items item) {
        ServiceCharges currentCharge = FREE;
        for (ServiceCharges charge : ServiceCharges.values()) {
            if( checkChargeOnItem(item, charge)) {
                if (currentCharge.getPercentage() < charge.getPercentage()) {
                    currentCharge = charge;
                }
            }
        }
        return currentCharge;
    }
    
    private static boolean checkChargeOnItem(Items item, ServiceCharges charge) {
        for (FoodType foodType : charge.getFoodTypes()) {
            if(foodType.triggeredBy(item.getProperties())) {
                return true;
            }
        }
        return false;
    }
}