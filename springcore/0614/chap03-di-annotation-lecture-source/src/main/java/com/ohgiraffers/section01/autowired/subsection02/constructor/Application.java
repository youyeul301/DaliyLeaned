package com.ohgiraffers.section01.autowired.subsection02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService=context.getBean("bookServiceConstructor",BookService.class);

        bookService.findAllBooks().forEach(System.out::println);

        System.out.println("bookService.searchBookBySequence(1) = " + bookService.searchBookBySequence(1));
    }
}
