package com.isoft.servlet.entity;

//工作岗位管理
public class EmpJob {
    private int id;
    private String eid;
    private String dno;
    private String job;

    public EmpJob(){}
    public EmpJob(int id, String eid, String dno, String job) {
        this.id = id;
        this.eid = eid;
        this.dno = dno;
        this.job = job;
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

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
