package com.example.infantcare.controller;

import com.example.infantcare.pojo.ClientInfo;
import com.example.infantcare.pojo.Nusery;
import com.example.infantcare.service.ClientInfoService;
import com.example.infantcare.service.NuseryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NuseryController {
    @Autowired
    NuseryService nuseryService;
    @PostMapping("/addNusery")
    public String addNusery(@RequestBody Map<String,Object> map){
        String name =( String) map.get("name");
        String imageurl =(String) map.get("imageurl");
        String age =( String) map.get("age");
        String constellation =( String) map.get("constellation");
        String edulevel =( String) map.get("edulevel");
        String marry =( String) map.get("marry");
        String credential =( String) map.get("credential");
        String level =( String) map.get("level");
        String reason =( String) map.get("reason");
        String work =( String) map.get("work");

        Nusery nusery = new Nusery(0,name,imageurl,Integer.parseInt(age),constellation,edulevel,
                marry,credential,Integer.parseInt(level),reason,work);

        if(nuseryService.addNusery(nusery) < 0){
            return "添加失败";
        }
        return "添加成功";
    }

    @GetMapping("/getNuserys")
    public Map<String,Object> getNuserys(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = nuseryService.getNuserys();
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
