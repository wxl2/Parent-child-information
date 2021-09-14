package com.example.infantcare.service;

import com.example.infantcare.dao.StatementMapper;
import com.example.infantcare.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatementService {
    @Autowired
    StatementMapper stamapper;

    public int addOrder(Order o) {
        try {
            stamapper.insertOrder(o);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Map<String,Object>> getOrder( ) {
        try {
            List<Map<String,Object>> list = stamapper.selectOrder();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
