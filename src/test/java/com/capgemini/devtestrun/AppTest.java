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
    
}
