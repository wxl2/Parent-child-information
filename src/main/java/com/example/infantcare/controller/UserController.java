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
        User user = new User(username,passwd);
        User  data = userService.login(user);
        res.put("status","success");
        res.put("data","");
        return res;
    }
    @PostMapping("/test")
    public void test(@RequestBody Map<String,Object> map, HttpServletResponse response, HttpServletRequest request) {
        map.get("appointment");
    }
}
