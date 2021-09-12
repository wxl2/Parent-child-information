package com.example.infantcare.controller;

import com.example.infantcare.pojo.User;
import com.example.infantcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> map, HttpServletResponse response, HttpServletRequest request){
        String code = (String) map.get("code");
        String username = (String)map.get("loginUsername");
        String passwd = (String)map.get("loginPassword");
        Map<String, Object> res = new HashMap<String, Object>();
        if(!RandomValidateCode.checkCode(request,response,code)){
            res.put("status","falid");
            res.put("data","验证码错误");
            return res;
        }
        User user = new User(username,passwd,null,null,null);
        User  data = userService.login(user);
        if(data == null) {
            res.put("status", "falid");
            res.put("data", "用户名或密码错误");
        }else if(data.getRole().equals("1")){
            res.put("status", "success");
            res.put("data", "admin.html");
            request.getSession().setAttribute("admin",user.getUsername());
        }else if(data.getRole().equals("2")){
            res.put("status", "success");
            res.put("data", "user.html");
            request.getSession().setAttribute("store",user.getUsername());
        }else{
            res.put("status", "success");
            res.put("data", "user.html");
            request.getSession().setAttribute("user",user.getUsername());
        }
        request.getSession().setAttribute("username",user.getUsername());
        return res;
    }
    @PostMapping("/register")
    public String register(@RequestBody Map<String,Object> map){
        String userName = (String) map.get("registerUsername");
        String passwd = (String) map.get("registerPassword");
        String WellPasswd = (String) map.get("registerWellPassword");
        if(!passwd.equals(WellPasswd)){
            return "两次密码输入不一致";
        }
        User user = new User(userName,passwd,"0",null,null);
        if(userService.register(user)==0)
            return "注册成功";
        else return "注册失败";
    }
}
