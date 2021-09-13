package com.example.infantcare.pojo;

public class Nusery {
    private int id;
    private String name;
    private String imageurl;
    private int age;
    private String constellation;
    private String edulevel;
    private String marry;
    private String credential;
    private int level;
    private String reason;
    private String work;

    public int getId() {
        return id;
    }

    public Nusery(int id, String name, String imageurl, int age, String constellation, String edulevel, String marry, String credential, int level, String reason, String work) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.age = age;
        this.constellation = constellation;
        this.edulevel = edulevel;
        this.marry = marry;
        this.credential = credential;
        this.level = level;
        this.reason = reason;
        this.work = work;
    }
    public Nusery(){}
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getEdulevel() {
        return edulevel;
    }

    public void setEdulevel(String edulevel) {
        this.edulevel = edulevel;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
