package com.example.infantcare.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.pojo.NuseryWorking;
import com.example.infantcare.pojo.Order;
import com.example.infantcare.service.WorkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WorkingController {
    @Autowired
    WorkingService workingService;
    @PostMapping("/addWorking")
    public String addWorking(@RequestBody String data){
        JSONObject obj = JSON.parseObject(data);
        int id = obj.getInteger("id");
        String name = obj.getString("name");
        String imageurl = obj.getString("imageurl");
        String addr = obj.getString("addr");
        String date = obj.getString("date");

        NuseryWorking nuseryWorking = new NuseryWorking(id,name,imageurl,addr,date);
        if(workingService.addWorkerRecord(nuseryWorking) < 0){
            return "操作失败";
        }
        return "操作成功";
    }

    @GetMapping("/getWorking")
    public Map<String,Object> getWorking(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = workingService.getWorkerRecords();
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
