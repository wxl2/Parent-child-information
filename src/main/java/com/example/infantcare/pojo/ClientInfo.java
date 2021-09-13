package com.example.infantcare.pojo;

import java.sql.Timestamp;

public class ClientInfo {
    private int id;
    private String name;
    private int inviter;
    private String phone;
    private String appointment;

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

    public int getInviter() {
        return inviter;
    }

    public void setInviter(int inviter) {
        this.inviter = inviter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public ClientInfo(int id, String name, int inviter, String phone, String appointment) {
        this.id = id;
        this.name = name;
        this.inviter = inviter;
        this.phone = phone;
        this.appointment = appointment;
    }
    public  ClientInfo(){}
}
