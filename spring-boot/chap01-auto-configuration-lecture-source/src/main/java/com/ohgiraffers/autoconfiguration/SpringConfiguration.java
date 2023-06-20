package com.ohgiraffers.autoconfiguration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfiguration {

    @Value("${test.value}")
    public String value;

    @Value("${test.list}")
//    public List<String >list;
    private String[] list;
    
    @Value("${test.greeting}")
    private String greeting;

    @Value("${test.array}")
    private Set<String> array;

    @Value("${username}")
    private String username;
    
    @Bean
    public Object propertyReadTest(){
        System.out.println("value :"+value);

//        list.forEach(System.out::println);
//        Arrays.stream(list).forEach(System.out::println);

        System.out.println("greeting = " + greeting);
        System.out.println("username = " + username);

        array.forEach(System.out::println);
        return new Object();

    }
}
