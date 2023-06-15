package com.ohgiraffers.common;

public abstract class Product {

    private String name;
    private int price;

    Product() {

    }

    Product(String name,int price){
        this.name = name;
        this.price=price;
    }

    @Override
    public String toString() {
        return name + " "+price;
    }
}
