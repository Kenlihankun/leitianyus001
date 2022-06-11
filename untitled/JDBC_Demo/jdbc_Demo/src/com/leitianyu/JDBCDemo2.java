package com.leitianyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");


        String password="1234";
        String username="root";
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        Connection conn = DriverManager.getConnection(url,username,password);


        String sql1= "UPDATE tb_user SET id=4 WHERE id=1;";
        String sql2= "UPDATE tb_user SET id=3 WHERE id=2;";

        Statement sta = conn.createStatement();


        try {
            conn.setAutoCommit(false);
            int a1 =sta.executeUpdate(sql1);


            System.out.println(a1);
            int a2 =sta.executeUpdate(sql2);


            System.out.println(a2);
            conn.commit();
        } catch (Exception throwables) {
            conn.rollback();

            throwables.printStackTrace();
        }
        sta.close();
        conn.close();
    }

}
