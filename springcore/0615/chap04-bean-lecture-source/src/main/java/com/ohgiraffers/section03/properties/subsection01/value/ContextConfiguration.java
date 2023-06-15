package com.ohgiraffers.section03.properties.subsection01.value;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@Configuration
@PropertySource("section03/properties/subsection01/value/product-info.properties")
public class ContextConfiguration {
    @Value("${bread.carpbread.name:팥붕어빵}")
    private String carpBreadName;
    /* :대체값*/
    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name:}")
    private String milkName;
    @Value("${beverage.milk.price:0}")
    private int milkPrice;
    @Value("${beverage.milk.capacity:0}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName,carpBreadPrice, new Date());
    }
    @Bean
    public Product milk(){
        return new Beverage(milkName,milkPrice,milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price:0}")  int waterPrice,
                         @Value("${beverage.water.capacity:0}")  int waterCapacity){
        return new Beverage(waterName,waterPrice,waterCapacity);
    }
}
