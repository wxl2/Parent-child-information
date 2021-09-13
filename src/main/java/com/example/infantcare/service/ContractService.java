package com.example.infantcare.service;

import com.example.infantcare.dao.ContractMapper;
import com.example.infantcare.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ContractService")
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;

    //添加合同
    public int addContract(Contract contract){
        try {
            contractMapper.insertContract(contract);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    //显示合同
    public List<Map<String,Object>> getContract(){
        try {
            List<Map<String,Object>> list = contractMapper.selectContract();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
