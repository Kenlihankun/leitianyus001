package com.leitianyu.mapper;

import com.leitianyu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {


    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password};")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username};")
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    public int add(User user);
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from tb_user;")
    List<User> SelectAll();

    /**
     * 更改用户信息
     * @param user
     */
    @Update("update tb_user set  username=#{username},password=#{password}  where id=#{id};")
    void UpdateUser(User user);

    /**
     * 根据用户名和ID查询用户对象
     *
     * @return
     */
    @Select("select * from tb_user where username = #{username} and id = #{id};")
    User selectByIdAndUsername(User user);

    /**
     * 根据ID查询用户对象
     * @param user
     * @return
     */
    @Select("select * from tb_user where id=#{id};")
    User selectById(User user);
}
