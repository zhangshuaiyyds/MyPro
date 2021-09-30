package com.isoft.servlet.entity;

//部门封装类
public class Dept {
    private int id;
    private String dno;
    private String dname;
    private String dmg;

    public Dept(){}
    public Dept(int id, String dno, String dname, String dmg) {
        this.id = id;
        this.dno = dno;
        this.dname = dname;
        this.dmg = dmg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmg() {
        return dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }
}
