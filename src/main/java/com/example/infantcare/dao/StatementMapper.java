package com.example.infantcare.dao;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StatementMapper {
    @Select("")
    public List<Map<String,Object>> selectWorkNursery();
}
