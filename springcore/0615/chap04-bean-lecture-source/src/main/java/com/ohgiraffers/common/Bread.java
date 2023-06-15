package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product {
    public java.util.Date bakedDate;

    Bread(){
//        super();
    }

    public Bread(String name, int price, java.util.Date bakedDate){
        super(name,price);
        this.bakedDate=bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " +bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }
}
