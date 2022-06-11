package com.leitianyu.test;

import com.leitianyu.Mapper.BrandMapper;
import com.leitianyu.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectALL();

        System.out.println(brands);

        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {

        Integer id = 1;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.SelectById(id);

        System.out.println(brand);

        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {

        Integer status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> list = mapper.selectByCondition(status,companyName,brandName);

        System.out.println(list);

        sqlSession.close();

    }

}
