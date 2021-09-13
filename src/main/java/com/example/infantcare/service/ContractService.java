package com.example.infantcare.service;

import com.example.infantcare.dao.ContractMapper;
import com.example.infantcare.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContractService")
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;
    public int addContract(Contract contract){
        try {
            contractMapper.insertContract(contract);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }



}
