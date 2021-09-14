package com.example.infantcare.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.dao.StatementMapper;
import com.example.infantcare.pojo.Order;
import com.example.infantcare.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class StatementController {
    @Autowired
    StatementService staService;

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody String data){
        JSONObject obj = JSON.parseObject(data);
        String salesman =obj.getString("salesman");
        String name = obj.getString("name");
        String phone = obj.getString("phone");
        String requirement = obj.getString("requirement");
        Double money = obj.getDouble("money");
        String date = obj.getString("date");
        String status = obj.getString("status");

        Order order = new Order(0,salesman,name,phone,requirement,money,date,status);
        int result = staService.addOrder(order);
        if(result < 0){
            return "操作失败";
        }
        return "操作成功";
    }

    @GetMapping("/getOrder")
    public Map<String,Object> getOrder(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = staService.getOrder();
        if(c_list == null){
            map.put("code","-1");
            map.put("msg","暂无数据");
            map.put("count",0);
            map.put("data","[]");
        }
        else{
            map.put("code","0");
            map.put("msg","ok");
            map.put("count",c_list.size());
            map.put("data",c_list);
        }
        return map;
    }
}
