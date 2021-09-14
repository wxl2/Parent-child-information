package com.example.infantcare.pojo;

//育婴师简历

public class Nusery {
    private int id;
    private String name;                //姓名
    private String imageurl;            //照片
    private String age;                    //年龄
    private String constellation;       //星座
    private String edulevel;            //学历
    private String marry;               //婚姻状况
    private String credential;          //证书
    private int level;                  //级别
    private String reason;              //推荐理由
    private String work;                //工作经历
    private String status;              //在职状态

    public int getId() {
        return id;
    }

    public Nusery(int id, String name, String imageurl, String age, String constellation, String edulevel, String marry, String credential, int level, String reason, String work, String status) {
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
        this.status = status;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
