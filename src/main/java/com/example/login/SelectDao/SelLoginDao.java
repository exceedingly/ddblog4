package com.example.login.SelectDao;

import com.example.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelLoginDao {

    @Select("select * from user where username = #{username} and password = #{password}")
    User SelectUserById(User user);

}
