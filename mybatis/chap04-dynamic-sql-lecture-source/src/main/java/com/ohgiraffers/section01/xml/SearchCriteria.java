package com.ohgiraffers.section01.xml;

public class SearchCriteria {
    private String condition;
    private String value;

    public SearchCriteria(String condition,String value){
        this.condition=condition;
        this.value=value;
    }

    public SearchCriteria() {

    }

    public String getCondition() {
        return condition;
    }

    public String getValue() {
        return value;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
