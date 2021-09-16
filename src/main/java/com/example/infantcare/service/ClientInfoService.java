package com.example.infantcare.service;

import com.example.infantcare.dao.ClientInfoMapper;
import com.example.infantcare.dao.UserDao;
import com.example.infantcare.pojo.ClientInfo;
import com.example.infantcare.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service("ClientInfoService")
public class ClientInfoService {
    @Autowired
    private ClientInfoMapper info;

    //添加客户信息
    public int addClientInfo(ClientInfo clientInfo){
        try {
            info.insertClient(clientInfo);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    //显示客户信息
    public List<Map<String,Object>> getClientInfos(){
        try {
            List<Map<String,Object>> list = info.selectClients();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
     //显示跟进记录
    public List<Map<String,Object>> getFollowRecord(){
        try {
            List<Map<String,Object>> list = info.getFollowRecord();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // 发送邮件sendSimpleMail
    public int sendSimpleMail(String firmMail,String password,String clientMail,String textContent){

        return 0;
    }

}
