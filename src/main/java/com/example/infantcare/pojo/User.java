package com.example.infantcare.pojo;

import lombok.Data;
@Data
public class User {
    private String username;
    private String password;
    private String role;
    private String phone;
    private String addr;

    /*
        0:-->普通用户
        1:-->管理员
        2:-->商家
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(String username, String password, String role, String phone, String addr) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.addr = addr;
    }

    public User(){}
    public void setRole(String role) {
        this.role = role;
    }
}
