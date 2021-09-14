package com.example.infantcare.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.pojo.Nusery;
import com.example.infantcare.service.NuseryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NuseryController {
    @Autowired
    NuseryService nuseryService;
    @PostMapping("/addNusery")
    public Map<String,Object> addNusery(@RequestParam("file") MultipartFile file, @RequestParam("params")String params){
        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject obj = JSON.parseObject(params);
        String name = obj.getString("name");
        String age = obj.getString("age");
        String constellation = obj.getString("constellation");
        String edulevel = obj.getString("edulevel");
        String marry = obj.getString("marry");
        String credential = obj.getString("credential");
        int level = obj.getInteger("level");
        String reason = obj.getString("reason");
        String work = obj.getString("work");


        try{
            Date now = new Date();
            SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/images/head";
            String fileName = f.format(now)+file.getOriginalFilename();
            String filePath = path+'/'+fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            Nusery nusery = new Nusery(0,name,fileName,age,constellation,edulevel,
                    marry,credential,level,reason,work,"");
            if(nuseryService.addNusery(nusery) < 0){
                map.put("code",-1);
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            return map;
        }
        map.put("code",0);
        return map;
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
    // 获取在职人员数据
    @GetMapping("/getEntrant")
    public Map<String,Object> getEntrant(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = nuseryService.getEntrant();
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

    @GetMapping("/getDimission")
    public Map<String,Object> getDimission(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = nuseryService.getDimission();
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
    @PostMapping("/updateNursery")
    public String updateNursery(@RequestBody String id){
        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject obj = JSON.parseObject(id);
        int result = nuseryService.updateNursery(obj.getInteger("id"));
        if(result < 0){
            return "操作失败";
        }

        return "操作成功";
    }
}
