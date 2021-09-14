package com.example.infantcare.dao;

import com.example.infantcare.pojo.Visiting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface VistingMapper {

    @Insert("INSERT INTO visiting(`name`, `phone`, `addr`, `requirement`, `date`, `content`, `worker`) VALUES " +
            "(#{name}, #{phone}, #{addr}, #{requirement}, #{date}, #{content}, #{worker})")
    public void insertVisting(Visiting visiting);

    @Select("SELECT * FROM  visiting")
    public List<Map<String,Object>> selectVistings();
}
