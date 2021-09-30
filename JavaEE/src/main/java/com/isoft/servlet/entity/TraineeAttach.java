package com.isoft.servlet.entity;

//实习生附加信息
public class TraineeAttach {
    private int id;
    private String eid;
    private String school;
    private String classes;
    private String pInter;
    private int standard;
    private double salStandard;
    private int state;

    public TraineeAttach(){}
    public TraineeAttach(int id,String eid, String school, String classes, String pInter, int standard, double salStandard,int state) {
        this.id = id;
        this.eid = eid;
        this.school = school;
        this.classes = classes;
        this.pInter = pInter;
        this.standard = standard;
        this.salStandard = salStandard;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getpInter() {
        return pInter;
    }

    public void setpInter(String pInter) {
        this.pInter = pInter;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public double getSalStandard() {
        return salStandard;
    }

    public void setSalStandard(double salStandard) {
        this.salStandard = salStandard;
    }
}
