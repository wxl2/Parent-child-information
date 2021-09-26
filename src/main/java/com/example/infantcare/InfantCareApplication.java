package com.example.infantcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.infantcare.dao"})
@ServletComponentScan
public class InfantCareApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfantCareApplication.class, args);
    }

}