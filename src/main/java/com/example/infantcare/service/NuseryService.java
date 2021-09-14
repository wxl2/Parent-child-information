package com.example.infantcare.service;

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
    public List<Map<String,Object>> getEntrant(){
        try {
            List<Map<String,Object>> list = nuseryMapper.getEntrant();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Map<String,Object>> getDimission(){
        try {
            List<Map<String,Object>> list = nuseryMapper.getDimission();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //  修改  员工从在职变为离职
    public int updateNursery(int id){
        try {
            int list = nuseryMapper.updateNursery(id);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int updateLevel(int id,int level){
        try {
            nuseryMapper.updateLevel(id,level);
            nuseryMapper.insertUpgradeTable(id,level-1,level);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public  List<Map<String,Object>> getUpgradeRecord(){
        try {
            List<Map<String,Object>> list = nuseryMapper.selectUpgradeRecord();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}