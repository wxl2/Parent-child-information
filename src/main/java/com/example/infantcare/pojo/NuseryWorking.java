package com.example.infantcare.pojo;

public class NuseryWorking {
    private int id;
    private String name;
    private String imageurl;
    private String addr;
    private String date;

    public NuseryWorking() {
    }

    public NuseryWorking(int id, String name, String imageurl, String addr, String date) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.addr = addr;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
