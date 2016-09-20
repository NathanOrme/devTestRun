package com.capgemini.devtestrun;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.devtestrun.items.Items;
import com.capgemini.devtestrun.items.Order;



/**
 * Unit test for simple App.
 */
public class AppTest {

	Order o;

	@Before
	public void setUp(){
		o = new Order();
	}

	@Test
	public void DoubleColaOrder() {
		Items cola = Items.COLA;
		o = App.addItem(o,cola);
		o = App.addItem(o,cola);
		assertEquals(Items.COLA.getPrice()*2, o.printTotalCostOfOrder(), 0.1);
	}

	@Test
	public void CoffeeCola() {
		Items i1 = Items.COLA;
		Items i2 = Items.COFFEE;
		o = App.addItem(o, i1);
		o = App.addItem(o, i2);
		double total = Items.COLA.getPrice() + Items.COFFEE.getPrice();
		assertEquals(total,o.printTotalCostOfOrder(), 0.1);
	}

	@Test
	public void CoffeeSteak(){
		Items i1 = Items.STEAKSANDWICH;
		Items i2 = Items.COFFEE;
		o = App.addItem(o, i2);
		o = App.addItem(o, i1);
		double total = Items.COFFEE.getPrice() + Items.STEAKSANDWICH.getPrice();
		total = (total/100)*120;
		assertEquals(total, o.printTotalCostOfOrder(), 0.1);

	}


}
