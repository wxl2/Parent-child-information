package com.example.infantcare.service;



import com.example.infantcare.dao.VisitingMapper;
import com.example.infantcare.pojo.Visiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("VistingService")
public class VisitingService {
    @Autowired
    private VisitingMapper visitingMapper;
    public int addVisiting(Visiting visiting){
        try {
            visitingMapper.insertVisiting(visiting);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public List<Map<String,Object>> getVisitings(){
        try {
            List<Map<String,Object>> list = visitingMapper.selectVisitings();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
