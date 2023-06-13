package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VendingMachineDAO {
    private final Map<Integer, VendingMachine> vendingMachineMap;

    public VendingMachineDAO(){
        this.vendingMachineMap = new HashMap<>();

        this.vendingMachineMap.put(1,new VendingMachine(1,2000,"사이다"));
        this.vendingMachineMap.put(2,new VendingMachine(2,1400,"콜라"));
        this.vendingMachineMap.put(3,new VendingMachine(3,1800,"식혜"));
        this.vendingMachineMap.put(4,new VendingMachine(4,1100,"매실차"));
    }

    public String returnToDrinkName(int drinkNum,int drinkPrice){
        String msg = "";
        if(drinkPrice >= vendingMachineMap.get(drinkNum).getDrinkPrice()){
            msg=(String)vendingMachineMap.get(drinkNum).getDrinkName();
        }else{
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        return msg;
    }
}
