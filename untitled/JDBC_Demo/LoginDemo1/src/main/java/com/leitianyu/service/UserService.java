package com.leitianyu.service;

import com.leitianyu.mapper.UserMapper;
import com.leitianyu.pojo.User;
import com.leitianyu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 根据用户名和密码查询用户对象
     * @param user
     * @return
     */
    public User select(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.select(user.getUsername(), user.getPassword());
        sqlSession.close();
        return user1;
    }
    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }
    /**
     * 添加用户
     * @param user
     */
    public User add(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(user);

        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.SelectAll();
        sqlSession.close();
        return users;
    }
    /**
     * 更改用户信息
     * @param user
     */
    public void UpdateUser(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.UpdateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据用户名和ID查询用户对象
     * @param user
     * @return
     */
    public User selectByIdAndUsername(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User users = mapper.selectByIdAndUsername(user);
        sqlSession.close();
        return users;
    }
    public User selectById(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 =mapper.selectById(user);
        sqlSession.close();
        return user1;
    }
}
