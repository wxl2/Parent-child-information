package com.example.infantcare.dao;


import com.example.infantcare.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StatementMapper {
    //  查询具有工作任务的育婴师
    @Select("")
    public List<Map<String,Object>> selectWorkNursery();

    //  添加订单
    @Insert("INSERT into sales(salesman,`name`,phone,requirement,money,`date`,`status`) values(#{salesman},#{name}" +
            ",#{phone},#{requirement},#{money},#{date},#{status})")
    public  int insertOrder(Order o);

    //展示订单
    @Select("select * from sales")
    public List<Map<String,Object>> selectOrder();
}
