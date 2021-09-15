package com.example.infantcare.pojo;

public class NuseryLeusyre {
    private int id;
    private String name;
    private String imageurl;
    private int level;
    private String nursery_addr;
    private String starttime;
    private String endtime;

    public NuseryLeusyre() {
    }

    public NuseryLeusyre(int id, String name, String imageurl, int level, String nursery_addr, String starttime, String endtime) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.level = level;
        this.nursery_addr = nursery_addr;
        this.starttime = starttime;
        this.endtime = endtime;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNursery_addr() {
        return nursery_addr;
    }

    public void setNursery_addr(String nursery_addr) {
        this.nursery_addr = nursery_addr;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
