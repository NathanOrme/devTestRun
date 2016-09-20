package com.capgemini.devtestrun.items;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItems> orders = new ArrayList<OrderItems>();
	private double totalCost = 0;

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
			totalCost = totalOrderPrice();
		} else {
			totalCost = 0;
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