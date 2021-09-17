package com.example.infantcare.pojo;

public class FollowRecord {
    int id;
    String recordTime;
    String contacts;
    String relation;
    String communicate;

    public FollowRecord() {
    }

    public FollowRecord(int id, String recordTime, String contacts, String relation, String communicate) {
        this.id = id;
        this.recordTime = recordTime;
        this.contacts = contacts;
        this.relation = relation;
        this.communicate = communicate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCommunicate() {
        return communicate;
    }

    public void setCommunicate(String communicate) {
        this.communicate = communicate;
    }
}
