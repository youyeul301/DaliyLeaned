package com.ohgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.section01.connection.Application2.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = " + con);

        close(con);
    }
}
