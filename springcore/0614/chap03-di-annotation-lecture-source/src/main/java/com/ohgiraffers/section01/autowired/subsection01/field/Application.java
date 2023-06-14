package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        //ComponentScan 대신 사용가능 가변인자라서 ,후 다른 패키지 주소를 추가 할수도 있음
        BookService bookService=context.getBean("bookServiceField",BookService.class);

        List<Book> books=bookService.findAllBooks();
        for (Book book:books){
            System.out.println("book = " + book);
        }
    }
}
