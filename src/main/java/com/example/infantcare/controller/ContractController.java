package com.example.infantcare.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.infantcare.pojo.Contract;
import com.example.infantcare.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        Double conMoney = Double.parseDouble((String) map.get("conMoney"));
        Contract contract = new Contract(0, name, phone, confinement, requireDate, requirement, nursery,conMoney);
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


    @GetMapping("/getResume")
    public Map<String, Object> getResume(@RequestParam("page")int page,
                                         @RequestParam("limit")int limit) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> c_list = contractService.getResume(page,limit);
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

    @GetMapping("/getIdNursery")
    public Map<String, Object> getIdNursery(@RequestParam("id")int id) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> c_map = contractService.getIdNursery(id);
        if (c_map == null) {
            map.put("code", "-1");
            map.put("msg", "暂无数据");
            map.put("count", 0);
            map.put("data", "[]");
        } else {
            map.put("code", "0");
            map.put("msg", "ok");
            map.put("count", 1);
            map.put("data", c_map);
        }
        return map;
    }
}
