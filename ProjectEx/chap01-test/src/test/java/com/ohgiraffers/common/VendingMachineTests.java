package com.ohgiraffers.common;

import com.ohgiraffers.javaconfig.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class VendingMachineTests {
    @Autowired
    private VendingMachineDAO vendingMachineDAO;

    @Test
    public void testDrink(){
        int drinkNum= 2;
        int price=2000;
        //when
        assertEquals("콜라",vendingMachineDAO.returnToDrinkName(drinkNum,price));
    }
}
