package com.ohgiraffers.section01.xmlmapper;

public class MenuDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String oderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = oderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", oderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    public MenuDTO() {
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String oderableStatus) {
        this.orderableStatus = oderableStatus;
    }
}
