package com.leitianyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");


        String password="1234";
        String username="root";
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        Connection conn = DriverManager.getConnection(url,username,password);


        String sql= "UPDATE tb_user SET id=1 WHERE id=4;";


        Statement sta = conn.createStatement();


        int a =sta.executeUpdate(sql);


        System.out.println(a);
        sta.close();
        conn.close();
    }

}
