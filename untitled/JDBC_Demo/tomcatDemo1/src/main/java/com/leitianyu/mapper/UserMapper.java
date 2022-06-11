package com.leitianyu.mapper;

import com.leitianyu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //用户登录
    @Select("select * from tb_user where username = #{username} and password = #{password};")
    User select(@Param("username") String username, @Param("password") String password);
    @Select("select * from tb_user where username=#{username} ;")
    User selectUsername(String username);
    @Insert("insert into tb_user values (null,#{username},#{password});")
    void add(User user);
}
