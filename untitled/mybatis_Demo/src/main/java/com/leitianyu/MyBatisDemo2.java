package com.leitianyu;

import com.leitianyu.Mapper.UserMapper;
import com.leitianyu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo2 {


    public static void main(String[] args) throws IOException {



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        执行sql
//        List<User> users = sqlSession.selectList("test.selectALL");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectALL();

        System.out.println(users);

        sqlSession.close();

    }


}
