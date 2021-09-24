package com.example.infantcare.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.pojo.Visiting;
import com.example.infantcare.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VisitingController {
    @Autowired
    VisitingService visitingService;
    @PostMapping("/addVisiting")
    public String addVisiting(@RequestBody String text){
        JSONObject obj = JSON.parseObject(text);
        String name = obj.getString("name");
        String phone = obj.getString("phone");
        String addr = obj.getString("addr");
        String requirement = obj.getString("requirement");
        String date = obj.getString("date");
        String content = obj.getString("content");
        int worker = obj.getInteger("worker");
        Visiting visiting = new Visiting(name,phone, addr,requirement,date,content,worker);
        if(visitingService.addVisiting(visiting) < 0)
            return "操作失败";
        return "操作成功";
    }

    @GetMapping("/getVisitings")
    public Map<String,Object> getVisitings(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = visitingService.getVisitings();
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
