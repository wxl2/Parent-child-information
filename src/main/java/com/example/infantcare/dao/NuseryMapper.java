package com.example.infantcare.dao;

import com.example.infantcare.pojo.Nusery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NuseryMapper {
    @Insert("INSERT INTO nusery(`name`, `imageurl`, `age`, `constellation`, `edulevel`, `marry`, " +
            "`credential`, `level`, `reason`, `work`) VALUES (#{name}, #{imageurl}, #{age},#{constellation}, " +
            "#{edulevel},#{marry},#{credential}, #{level}, #{reason}, #{work})")
    public void insertNusery(Nusery nusery);
    @Select("SELECT * FROM nusery")
    public List<Map<String,Object>> selectNuserys();
}
