package com.capgemini.devtestrun.items;

public class OrderItems {
	
	private Items item;
    private int quantity = 1 ;
    
    /**
     * Default setup of item
     * Quantity equals 1 due to the fact that its a new item. 
     * @param item item being set up
     */
    public OrderItems(Items item) {
        this.quantity = 1;
        this.item = item;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addItem() {
        quantity++;
    }

}
