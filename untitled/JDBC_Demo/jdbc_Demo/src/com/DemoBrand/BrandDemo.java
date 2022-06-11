package com.DemoBrand;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandDemo {
    //查询所以
    @Test
    public void test() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();

        String sql = "select * from tb_brand;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet re = preparedStatement.executeQuery();

        try {
            List<Brand> list = new ArrayList<>();
            while (re.next()){list.add(new Brand(re.getInt("id"),re.getString("brand_name"),re.getString("company_name"), re.getInt("ordered"),re.getString("description"),re.getInt("status")));}
            System.out.println(list);
        } catch (SQLException throwables) {
            System.out.println(":this");
            throwables.printStackTrace();
        }

        re.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void test2() throws Exception {



        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();

        String sql = "insert into tb_brand (brand_name, company_name, ordered, description, status) values('cmj','打理公司',9999,'守护世界最可爱的草莓酱',1);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int a = preparedStatement.executeUpdate();
        if (a>0){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        preparedStatement.close();
        connection.close();
    }
}
