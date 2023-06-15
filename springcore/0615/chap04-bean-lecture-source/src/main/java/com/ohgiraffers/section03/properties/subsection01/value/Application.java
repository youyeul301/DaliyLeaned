package com.ohgiraffers.section03.properties.subsection01.value;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread" ,Bread.class);
        System.out.println(carpBread.toString());

        Product milk = context.getBean("milk" , Beverage.class);
        System.out.println(milk.toString());

        Product water= context.getBean("water",Beverage.class);
        System.out.println(water.toString());
    }

}
