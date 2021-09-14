package com.example.infantcare.dao;

import com.example.infantcare.pojo.Contract;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    @Insert("INSERT INTO contract(`id`,`name`,`phone`,`confinement`,`requiredate`,`requirement`,`nusery`) VALUES (#{id},#{name},#{phone},#{confinement},#{requiredate},#{requirement},#{nusery})")
    public void insertContract(Contract contract);

    @Select("SELECT name,phone,confinement,requiredate,requirement,nusery FROM contract")
    public List<Map<String,Object>> selectContract();
}
