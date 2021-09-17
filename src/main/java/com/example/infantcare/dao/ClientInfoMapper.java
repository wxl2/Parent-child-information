package com.example.infantcare.dao;

import com.example.infantcare.pojo.ClientInfo;
import com.example.infantcare.pojo.FollowRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ClientInfoMapper {
    @Insert("INSERT INTO clientinfo(`id`,`name`, `inviter`, `phone`,`appointment`) VALUES (#{id},#{name},#{inviter},#{phone},#{appointment})")
    public void insertClient(ClientInfo info);
    @Select("SELECT name,inviter,phone,DATE_FORMAT(appointment,'%Y-%m-%d %H:%i:%S') appointment FROM clientinfo")
    public List<Map<String,Object>> selectClients();

    // 获取跟进记录表
    @Select("SELECT clientinfo.id,`name`,DATE_FORMAT(recordTime,'%Y-%m-%d %H:%i:%S') recordTime,contacts,relation,communicate FROM follow_record,clientinfo where follow_record.id=clientinfo.id")
    public List<Map<String,Object>> getFollowRecord();

    // 添加跟进记录insertFollowRecord
    @Insert("INSERT INTO follow_record(`id`,`recordTime`, `contacts`, `relation`,`communicate`) VALUES (#{id}" +
            ",#{recordTime},#{contacts},#{relation},#{communicate})")
    public void insertFollowRecord(FollowRecord info);
}
