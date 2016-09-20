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
		for(OrderItems oi : orders) {
			String id = oi.getItem().getId();
			if(id != null && !id.isEmpty()){
				if (id.equalsIgnoreCase(item.getId())) {
					oi.addItem();
					return;
				}
			}
		}
		orders.add(new OrderItems(item));
		ServiceCharges tempCharge = serviceCharge.checkServiceCharge(item);
		if (tempCharge != ServiceCharges.FREE) {
			serviceCharge = tempCharge;
		}
	}

	public double printTotalCostOfOrder() {
		if(totalCost != 0){
			totalCost = Math.round(totalCost * 100.00) / 100.00;
			totalCost += printServiceCharge(totalCost);
		} else {
			totalCost = totalOrderPrice();
			totalCost += printServiceCharge(totalCost);
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

	public double printServiceCharge(double totalCost) {
		double serviceChargeCost = 0;
		serviceChargeCost = (totalCost/100)*serviceCharge.getPercentage();
		serviceChargeCost = Math.round(serviceChargeCost * 100.00) / 100.00;
		if(serviceCharge.getLimit() != 0) {
			if( serviceChargeCost > serviceCharge.getLimit()) {
				serviceChargeCost = serviceCharge.getLimit();
			}
		}
		System.out.println("Service Charge: £" + serviceChargeCost);
		return serviceChargeCost;
	}
}
