package com.example.infantcare.service;

import com.example.infantcare.dao.ClientInfoMapper;
import com.example.infantcare.dao.UserDao;
import com.example.infantcare.pojo.ClientInfo;
import com.example.infantcare.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ClientInfoService")
public class ClientInfoService {
    @Autowired
    private ClientInfoMapper info;
    public int addClientInfo(ClientInfo clientInfo){
        try {
            info.insertClient(clientInfo);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    public List<Map<String,Object>> getClientInfos(){
        try {
            List<Map<String,Object>> list = info.selectClients();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
