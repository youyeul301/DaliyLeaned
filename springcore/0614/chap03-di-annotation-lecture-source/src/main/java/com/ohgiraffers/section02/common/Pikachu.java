package com.ohgiraffers.section02.common;

import org.springframework.stereotype.Component;
//@Primary
@Component
public class Pikachu implements Pokemon{

    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!!");
    }
}
