package com.example.infantcare.service;

import com.example.infantcare.dao.ClientInfoMapper;
import com.example.infantcare.dao.NuseryMapper;
import com.example.infantcare.pojo.Nusery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("NuseryService")
public class NuseryService {
    @Autowired
    private NuseryMapper nuseryMapper;
    public int addNusery(Nusery nusery){
        try {
            nuseryMapper.insertNusery(nusery);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    public List<Map<String,Object>> getNuserys(){
        try {
            List<Map<String,Object>> list = nuseryMapper.selectNuserys();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}