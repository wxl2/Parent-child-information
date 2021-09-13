package com.example.infantcare.dao;

import com.example.infantcare.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserDao {
    @Insert("insert into user (`username`, `password`) values(#{username},#{password})")
    public void insertUser(User user);
    @Select("select * from user where username = #{username}")
    public User getUserByUserName(@Param("username") String username);
}
