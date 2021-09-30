package com.isoft.servlet.entity;

public class User {
    private int id;
    private String eid;
    private String username;
    private String password;

    public User(){}

    public User(int id, String eid, String username, String password) {
        this.id = id;
        this.eid = eid;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
