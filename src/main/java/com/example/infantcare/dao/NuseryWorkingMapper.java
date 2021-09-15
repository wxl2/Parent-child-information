package com.example.infantcare.dao;

import com.example.infantcare.pojo.NuseryLeusyre;
import com.example.infantcare.pojo.NuseryWorking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NuseryWorkingMapper {

    //工作表
    @Insert("INSERT INTO nursery_working(`id`, `name`, `imageurl`, `addr`, `date`) VALUES " +
            "(#{id}, #{name}, #{imageurl}, #{addr}, #{date})")
    public void insertNeseryWorking(NuseryWorking nuseryWorking);

    @Select("SELECT * FROM nursery_working")
    public List<Map<String,Object>> selectNeseryWorkings();

    ///空闲表
    @Insert("INSERT INTO nursery_leisure(`id`, `name`, `imageurl`, `level`, `nursery_addr`, `starttime`, `endtime`) VALUES " +
            "(#{id}, #{name}, #{imageurl}, #{level}, #{nursery_addr}, #{starttime}, #{endtime})")
    public  void  insertNeseryLeysyre(NuseryLeusyre nuseryLeusyre);

    @Select("SELECT * FROM nursery_leisure")
    public List<Map<String,Object>> selecttNeseryLeysyre();
}
