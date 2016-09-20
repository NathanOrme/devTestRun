package com.capgemini.devtestrun;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.devtestrun.items.Order;
import com.capgemini.devtestrun.items.service.ServiceCharges;


public class ServiceChargeTest {
    
    Order order;
    
    @Before
    public void setupOrder() {
        order = new Order();
    }
    
    @Test
    public void TEN_PERCENT_CHARGE_ON_100() {
        order.setServiceCharge(ServiceCharges.TEN_PERCENT);
        double value = order.printServiceCharge(100);
        assertEquals(value, 10.0, 0.1);
    }
    
    @Test
    public void TWENTY_PERCENT_CHARGE_100() {
        order.setServiceCharge(ServiceCharges.TWENTY_PERCENT);
        double value = order.printServiceCharge(100);
        assertEquals(value, 20.0, 0.1);
    }
    
    @Test
    public void TWENTY_PERCENT_CHARGE_FOR_25() {
        order.setServiceCharge(ServiceCharges.TWENTY_PERCENT);
        double value = order.printServiceCharge(25);
        assertEquals(value, 5.0, 0.1);
    }
}