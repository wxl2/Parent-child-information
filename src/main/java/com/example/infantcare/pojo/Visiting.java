package com.example.infantcare.pojo;

public class Visiting {
    private  String name;
    private  String phone;
    private  String addr;
    private  String requirement;
    private  String date;
    private  String content;
    private  int worker;

    public Visiting() {
    }

    public Visiting(String name, String phone, String addr, String requirement, String date, String content, int worker) {
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.requirement = requirement;
        this.date = date;
        this.content = content;
        this.worker = worker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWorker() {
        return worker;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }
}
