package com.ohgiraffers.section01.aop;

public class Member {

    private Long id;
    private String name;

    public Member(long id, String name) {
        this.id = id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
