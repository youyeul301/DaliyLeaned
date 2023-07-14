package com.ohgiraffers.section01.xmlmapper;

public class MenuAndCategoryDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;

    private CategoryDTO category;
    private String orderableStatus;

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    public MenuAndCategoryDTO() {
    }

    public MenuAndCategoryDTO(int menuCode, String menuName, int menuPrice, int categoryCode, CategoryDTO category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
}
