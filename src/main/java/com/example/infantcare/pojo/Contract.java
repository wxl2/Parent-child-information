package com.example.infantcare.pojo;

//合同信息表
public class Contract {
    private int id;
    private String name;                        //客户姓名
    private String phone;                       //客户电话
    private String confinementDate;             //预产期
    private String requireDate;                 //需求时间
    private String requirement;                 //需求内容
    private String nuseryName;                  //育婴师

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConfinementDate() {
        return confinementDate;
    }

    public void setConfinementDate(String confinementDate) {
        this.confinementDate = confinementDate;
    }

    public String getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(String requireDate) {
        this.requireDate = requireDate;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNuseryName() {
        return nuseryName;
    }

    public void setNuseryName(String nuseryName) {
        this.nuseryName = nuseryName;
    }

    public Contract(int id, String name, String phone, String confinementDate, String requireDate, String requirement, String nuseryName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.confinementDate = confinementDate;
        this.requireDate = requireDate;
        this.requirement = requirement;
        this.nuseryName = nuseryName;
    }

    public Contract() {
    }
}
