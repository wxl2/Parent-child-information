package com.example.infantcare.dao;

import com.example.infantcare.pojo.Nusery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface NuseryMapper {
    @Insert("INSERT INTO nursery(`name`, `imageurl`, `age`, `constellation`, `edulevel`, `marry`, " +
            "`credential`, `level`, `reason`, `work`) VALUES (#{name}, #{imageurl}, #{age},#{constellation}, " +
            "#{edulevel},#{marry},#{credential}, #{level}, #{reason}, #{work})")
    public void insertNusery(Nusery nursery);
    @Select("SELECT * FROM nursery")
    public List<Map<String,Object>> selectNuserys();

    @Select("SELECT * FROM nursery where condition_ ='在职'")
    public List<Map<String,Object>> getEntrant();


    // 修改
    @Update("update nursery set condition_='离职' where id=#{id} ")
    public int updateNursery(int id);
}
