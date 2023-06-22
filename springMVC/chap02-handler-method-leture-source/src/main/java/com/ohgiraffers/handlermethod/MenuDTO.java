package com.ohgiraffers.handlermethod;

public class MenuDTO {
    private String name;
    private int price;
    private int categoryCode;
    private String orderAbleStatus;

    public MenuDTO() {
    }

    public MenuDTO(String name, int price, int categoryCode, String orderAbleStatus) {
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderAbleStatus = orderAbleStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderAbleStatus() {
        return orderAbleStatus;
    }

    public void setOrderAbleStatus(String orderAbleStatus) {
        this.orderAbleStatus = orderAbleStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderAbleStatus='" + orderAbleStatus + '\'' +
                '}';
    }
}
