package com.example.infantcare.dao;

import com.example.infantcare.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserDao {
    @Insert("insert into user (`username`, `password`, `role`) values(#{username},#{password},#{role})")
    public void insertUser(User user);
    @Select("select * from user where username = #{username}")
    public User getUserByUserName(@Param("username") String username);
    @Update("update user set role=#{status} where username=#{username}")
    public void updateRole(@Param("status") String status,@Param("username") String username);
    @Update("update user set phone=#{phone},addr=#{addr} where username=#{username}")
    public void updatePhoneAddr(@Param("phone") String phone,@Param("addr") String addr,@Param("username") String username);
}
