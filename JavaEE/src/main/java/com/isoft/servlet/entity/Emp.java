package com.isoft.servlet.entity;

import java.util.Date;

//员工封装类
public class Emp {
    private int id;
    private String eid;
    private String name;
    private String sex;
    private String mail;
    private String phone;
    private String qq;
    private String address;
    private String postal;
    private String country;
    private String rpr;
    private String birthday;
    private String num;
    private String national;

    public Emp(){}
    public Emp(int id,String eid, String name, String sex, String mail, String phone, String qq, String address, String postal, String country, String rpr, String birthday,String num, String national) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.phone = phone;
        this.qq = qq;
        this.address = address;
        this.postal = postal;
        this.country = country;
        this.rpr = rpr;
        this.birthday = birthday;
        this.num = num;
        this.national = national;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRpr() {
        return rpr;
    }

    public void setRpr(String rpr) {
        this.rpr = rpr;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", postal='" + postal + '\'' +
                ", country='" + country + '\'' +
                ", rpr='" + rpr + '\'' +
                ", birthday='" + birthday + '\'' +
                ", num='" + num + '\'' +
                ", national='" + national + '\'' +
                '}';
    }
}
