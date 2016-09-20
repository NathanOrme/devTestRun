package com.capgemini.devtestrun.items;

import java.util.ArrayList;

import com.capgemini.devtestrun.items.service.ServiceCharges;


public class Order {
	private ArrayList<OrderItems> orders = new ArrayList<OrderItems>();
	private double totalCost = 0;
	private ServiceCharges serviceCharge = ServiceCharges.FREE;

    public void setServiceCharge(ServiceCharges serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

	public void addItem(Items item) {
		boolean found = false;
		for(OrderItems oi : orders) {
			String id = oi.getItem().getId();
			if(id != null && !id.isEmpty()){
				if (id.equalsIgnoreCase(item.getId())) {
					oi.addItem();
					found = true;
				}
			}
		}
		if(!found){
			orders.add(new OrderItems(item));
		}
	}

	public double printTotalCostOfOrder() {
		if(totalOrderPrice() != 0){
			totalCost = Math.round(totalCost * 100.00) / 100.00;
		} else {
			totalCost = totalOrderPrice();
		}
		System.out.println("Total Order Cost: £" + totalCost);
		return totalCost;
	}

	public double totalOrderPrice() {
		for(OrderItems item : orders) {
			totalCost += item.getQuantity() * item.getItem().getPrice();
		}        
		System.out.println("Total Cost Of Items: £" + totalCost);
		return totalCost;
	}
}
