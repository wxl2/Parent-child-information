package com.example.infantcare.pojo;


public class Order {
    private int id;
    private String salesman;
    private String name;
    private String phone;
    private String requirement;
    private double money;
    private String date;
    private String status;

    public Order() {
    }

    public Order(int id, String salesman, String name, String phone, String requirement, double money, String data, String status) {
        this.id = id;
        this.salesman = salesman;
        this.name = name;
        this.phone = phone;
        this.requirement = requirement;
        this.money = money;
        this.date = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
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

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
