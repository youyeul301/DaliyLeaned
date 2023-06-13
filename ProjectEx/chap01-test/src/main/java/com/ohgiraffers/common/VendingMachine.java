package com.ohgiraffers.common;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VendingMachine {
    int drinkNum;
    int drinkPrice;
    String drinkName;
}
