package com.isoft.servlet.entity;

//薪资管理
public class Salary {
    private int id;
    private String eid;
    private double pSal;
    private double bSal;
    private double tSub;
    private double cSub;
    private double tAllo;

    public Salary(){}
    public Salary(int id,String eid, double pSal, double bSal, double tSub, double cSub, double tAllo) {
        this.id = id;
        this.eid = eid;
        this.pSal = pSal;
        this.bSal = bSal;
        this.tSub = tSub;
        this.cSub = cSub;
        this.tAllo = tAllo;
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

    public double getpSal() {
        return pSal;
    }

    public void setpSal(double pSal) {
        this.pSal = pSal;
    }

    public double getbSal() {
        return bSal;
    }

    public void setbSal(double bSal) {
        this.bSal = bSal;
    }

    public double gettSub() {
        return tSub;
    }

    public void settSub(double tSub) {
        this.tSub = tSub;
    }

    public double getcSub() {
        return cSub;
    }

    public void setcSub(double cSub) {
        this.cSub = cSub;
    }

    public double gettAllo() {
        return tAllo;
    }

    public void settAllo(double tAllo) {
        this.tAllo = tAllo;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", pSal=" + pSal +
                ", bSal=" + bSal +
                ", tSub=" + tSub +
                ", cSub=" + cSub +
                ", tAllo=" + tAllo +
                '}';
    }
}
