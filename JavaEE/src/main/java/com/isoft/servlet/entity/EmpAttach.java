package com.isoft.servlet.entity;

import java.util.Date;

//员工附加信息
public class EmpAttach {
    private int id;
    private String eid;
    private String education;
    private String hiredate;
    private String bank;
    private String card;
    private String lce;
    private int state;

    public EmpAttach(){}
    public EmpAttach(int id ,String eid, String education, String hiredate, String bank, String card, String lce,int state) {
        this.id = id;
        this.eid = eid;
        this.education = education;
        this.hiredate = hiredate;
        this.bank = bank;
        this.card = card;
        this.lce = lce;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getLce() {
        return lce;
    }

    public void setLce(String lce) {
        this.lce = lce;
    }
}
