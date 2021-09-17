package com.example.infantcare.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.pojo.NuseryLeusyre;
import com.example.infantcare.pojo.NuseryWorking;
import com.example.infantcare.service.WorkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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


    @PostMapping("/addLeisure")
    public String addLeisure(@RequestBody String data){
        JSONObject obj = JSON.parseObject(data);
        int id = obj.getInteger("id");
        String name = obj.getString("name");
        String imageurl = obj.getString("imageurl");
        int level = obj.getInteger("level");
        String addr = obj.getString("nursery_addr");
        String starttime = obj.getString("starttime");
        String endtime = obj.getString("endtime");

        NuseryLeusyre nuseryLeusyre = new NuseryLeusyre(id,name,imageurl,level,addr,starttime,endtime);
        if(workingService.addLeisureRecord(nuseryLeusyre)< 0){
            return "操作失败";
        }
        return "操作成功";
    }

    @GetMapping("/getLeisure")
    public Map<String,Object> getLeisure(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> c_list = workingService.getLeisureRecords();
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

    @GetMapping("/getWorkerFree")
    public Map<String,Object> getWorkerFree(@RequestParam("id") int id){
        List<String> workerTimes = workingService.getWorkerTimes(id);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        List<String> all7Day = new ArrayList<String>();
        for(int i =0;i<7;i++){
            cal.add(Calendar.DAY_OF_MONTH, +1);
            all7Day.add(format.format(cal.getTime()));
        }
        for(int i=0;i<workerTimes.size();i++){
            all7Day.remove(workerTimes.get(i));
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("count",all7Day.size());
        map.put("data",all7Day);
        return map;
    }

}
