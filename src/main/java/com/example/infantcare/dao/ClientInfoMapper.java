package com.example.infantcare.dao;

import com.example.infantcare.pojo.ClientInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ClientInfoMapper {
    @Insert("INSERT INTO clientinfo(`id`,`name`, `inviter`, `phone`,`appointment`) VALUES (#{id},#{name},#{inviter},#{phone},#{appointment})")
    public void insertClient(ClientInfo info);
    @Select("SELECT name,inviter,phone,DATE_FORMAT(appointment,'%Y-%m-%d %H:%i:%S') appointment FROM clientinfo")
    public List<Map<String,Object>> selectClients();
}
