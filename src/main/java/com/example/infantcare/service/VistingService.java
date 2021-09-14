package com.example.infantcare.service;



import com.example.infantcare.dao.VistingMapper;
import com.example.infantcare.pojo.Visiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("VistingService")
public class VistingService {
    @Autowired
    private VistingMapper vistingMapper;
    public int addVisting(Visiting visiting){
        try {
            vistingMapper.insertVisting(visiting);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public List<Map<String,Object>> getVistings(){
        try {
            List<Map<String,Object>> list = vistingMapper.selectVistings();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
