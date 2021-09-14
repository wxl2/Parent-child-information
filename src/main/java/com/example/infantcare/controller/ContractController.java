package com.example.infantcare.controller;

import com.example.infantcare.pojo.Contract;
import com.example.infantcare.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    @PostMapping("/addContract")
    public String addContract(@RequestBody Map<String, Object> map) {

        String name = (String) map.get("name");
        String phone = (String) map.get("phone");
        String confinement = (String) map.get("confinement");
        String requireDate = (String) map.get("requireDate");
        String requirement = (String) map.get("requirement");
        String nursery = (String) map.get("nursery");
        Contract contract = new Contract(0, name, phone, confinement, requireDate, requirement, nursery);
        if (contractService.addContract(contract) < 0) {
            return "添加失败";
        }
        return "添加成功";
    }

    @GetMapping("/getContract")
    public Map<String, Object> getContract() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> c_list = contractService.getContract();
        if (c_list == null) {
            map.put("code", "-1");
            map.put("msg", "暂无数据");
            map.put("count", 0);
            map.put("data", "[]");
        } else {
            map.put("code", "0");
            map.put("msg", "ok");
            map.put("count", c_list.size());
            map.put("data", c_list);
        }
        return map;
    }

}
