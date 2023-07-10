package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application1 {
    public static void main(String[] args) {
        Connection con=getConnection();
        PreparedStatement pstmt =null;
        int result=0;

        String query1 ="UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE=?";        //SOFT DELETE
        String query2 ="DELETE FROM TBL_MENU WHERE MENU_CODE = ?";                            //HARD DELETE

        try {
            pstmt=con.prepareStatement(query2);
            pstmt.setInt(1,23);

            result=pstmt.executeUpdate();

            if(result>0){
                commit(con);
            }else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }

        System.out.println("result = " + result);

    }
}
