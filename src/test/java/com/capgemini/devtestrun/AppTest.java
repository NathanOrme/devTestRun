package com.capgemini.devtestrun;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.devtestrun.items.Items;
import com.capgemini.devtestrun.items.Order;



/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
    public void DoubleColaOrder() {
		Order o = new Order();
        Items cola = Items.COLA;
        o = App.addItem(o,cola);
        o = App.addItem(o,cola);
        assertEquals(Items.COLA.getPrice()*2, o.printTotalCostOfOrder(), 0.1);
    }
	
	@Test
	public void CoffeeCola() {
		Order o = new Order();
		Items i1 = Items.COLA;
		Items i2 = Items.COFFEE;
		o = App.addItem(o, i1);
		o = App.addItem(o, i2);
		double total = Items.COLA.getPrice() + Items.COFFEE.getPrice();
		assertEquals(total,o.printTotalCostOfOrder(), 0.1);
	}
    
}
