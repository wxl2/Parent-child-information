package com.example.infantcare.controller;


import com.example.infantcare.pojo.ClientInfo;
import com.example.infantcare.service.ClientInfoService;
import com.example.infantcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientInfoController {
    @Autowired
    ClientInfoService clientInfoService;
    @PostMapping("/addClientInfo")
    public String addClientInfo(@RequestBody Map<String,Object> map){
        String name =( String) map.get("name");
        String inviter =(String) map.get("inviter");
        String phone =( String) map.get("phone");
        String appointment =( String) map.get("appointment");
        ClientInfo info = new ClientInfo(0,name,Integer.parseInt(inviter),phone,appointment);
        if(clientInfoService.addClientInfo(info)<0){
            return "添加失败";
        }
        return "添加成功";
    }

    @GetMapping("/getClientInfos")
    public Map<String,Object> getClientInfos(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>>  c_list = clientInfoService.getClientInfos();
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

    @GetMapping("/getFollowRecord")
    public Map<String,Object> getFollowRecord(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>>  c_list = clientInfoService.getFollowRecord();
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
    // 邮件发送请求sendSimpleMail
    @PostMapping("/sendSimpleMail")
    public String sendSimpleMail(@RequestBody Map<String,Object> map){
        String firmMail =( String) map.get("firmMail");
        String password =(String) map.get("password");
        String clientMail =( String) map.get("clientMail");
        String textContent =( String) map.get("textContent");
        int result =0;
        try {
            result = clientInfoService.sendSimpleMail(firmMail,password,clientMail,textContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result < 0){
            return "发送失败";
        }else
        return "发送成功";
    }
}
