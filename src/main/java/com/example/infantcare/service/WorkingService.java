package com.example.infantcare.service;

import com.example.infantcare.dao.NuseryWorkingMapper;
import com.example.infantcare.pojo.Nusery;
import com.example.infantcare.pojo.NuseryLeusyre;
import com.example.infantcare.pojo.NuseryWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("Working")
public class WorkingService {
    @Autowired
    NuseryWorkingMapper nuseryWorkingMapper;

    public int addWorkerRecord(NuseryWorking  nuseryWorking){
        try {
            //  根据id获取到图片和名字
            Nusery idNusery = getIdNusery(nuseryWorking.getId());
            nuseryWorking.setImageurl(idNusery.getImageurl());
            nuseryWorking.setName(idNusery.getName());
            nuseryWorkingMapper.insertNeseryWorking(nuseryWorking);;
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public List<Map<String,Object>> getWorkerRecords(){
        try {
            List<Map<String,Object>> list = nuseryWorkingMapper.selectNeseryWorkings();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public int addLeisureRecord(NuseryLeusyre nuseryLeusyre){
        try {
            Nusery idNusery = getIdNusery(nuseryLeusyre.getId());
            nuseryLeusyre.setImageurl(idNusery.getImageurl());
            nuseryLeusyre.setLevel(idNusery.getLevel());
            nuseryWorkingMapper.insertNeseryLeysyre(nuseryLeusyre);;
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public List<Map<String,Object>> getLeisureRecords(){
        try {
            List<Map<String,Object>> list = null;
            list = nuseryWorkingMapper.selecttNeseryLeysyre();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getWorkerTimes(int id){
        try {
            List<String> list = nuseryWorkingMapper.selectWorkerTime(id);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Nusery getIdNusery(int id){
        Nusery data = null;
        try {
             data = nuseryWorkingMapper.getIdNusery(id);
            return data;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
