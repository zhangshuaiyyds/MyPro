package com.isoft.servlet.entity;

//五险一金管理
public class FiveIns {
    private int id;
    private String eid;
    private double edtInt;
    private double medInt;
    private double uetInt;
    private double emiInt;
    private double matInt;
    private double hpf;

    public FiveIns(){}
    public FiveIns(int id,String eid, double edtInt, double medInt, double uetInt, double emiInt, double matInt, double hpf) {
        this.id = id;
        this.eid = eid;
        this.edtInt = edtInt;
        this.medInt = medInt;
        this.uetInt = uetInt;
        this.emiInt = emiInt;
        this.matInt = matInt;
        this.hpf = hpf;
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

    public double getEdtInt() {
        return edtInt;
    }

    public void setEdtInt(double edtInt) {
        this.edtInt = edtInt;
    }

    public double getMedInt() {
        return medInt;
    }

    public void setMedInt(double medInt) {
        this.medInt = medInt;
    }

    public double getUetInt() {
        return uetInt;
    }

    public void setUetInt(double uetInt) {
        this.uetInt = uetInt;
    }

    public double getEmiInt() {
        return emiInt;
    }

    public void setEmiInt(double emiInt) {
        this.emiInt = emiInt;
    }

    public double getMatInt() {
        return matInt;
    }

    public void setMatInt(double matInt) {
        this.matInt = matInt;
    }

    public double getHpf() {
        return hpf;
    }

    public void setHpf(double hpf) {
        this.hpf = hpf;
    }

    @Override
    public String toString() {
        return "FiveIns{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", edtInt=" + edtInt +
                ", medInt=" + medInt +
                ", uetInt=" + uetInt +
                ", emiInt=" + emiInt +
                ", matInt=" + matInt +
                ", hpf=" + hpf +
                '}';
    }
}
