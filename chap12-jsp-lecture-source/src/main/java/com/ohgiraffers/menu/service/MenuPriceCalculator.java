package com.ohgiraffers.menu.service;

public class MenuPriceCalculator {
    public int calcOrderPrice(String menuName, int amount) {
        int orderPrice=0;

        switch (menuName){
            case "햄버거" : orderPrice = 6000 *amount; break;
            case "짜장면" : orderPrice = 7000 *amount; break;
            case "짬뽕" : orderPrice = 8000 *amount; break;
            case "순대국" : orderPrice = 5000 *amount; break;
        }

        return orderPrice;
    }

}