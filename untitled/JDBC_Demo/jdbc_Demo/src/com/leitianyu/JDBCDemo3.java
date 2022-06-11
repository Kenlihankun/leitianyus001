package com.leitianyu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo3 {

    @Test
    public void test() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");


            String password="1234";
            String username="root";
            String url="jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
            Connection conn = DriverManager.getConnection(url,username,password);


            String sql="select * from tb_user";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int anInt = resultSet.getInt("id");
            System.out.println(anInt);
        }

        resultSet.close();
        statement.close();
        conn.close();

    }


}
