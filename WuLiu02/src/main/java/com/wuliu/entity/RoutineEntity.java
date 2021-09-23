package com.wuliu.entity;

public class RoutineEntity {
    private int rid ;
    private String rname ;
    private CityEntity rbegincid;
    private CityEntity rendcid;
    private double rprice ;
    private int rbeizhu ;  //0可用使用  1 废掉

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public CityEntity getRbegincid() {
        return rbegincid;
    }

    public void setRbegincid(CityEntity rbegincid) {
        this.rbegincid = rbegincid;
    }

    public CityEntity getRendcid() {
        return rendcid;
    }

    public void setRendcid(CityEntity rendcid) {
        this.rendcid = rendcid;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public int getRbeizhu() {
        return rbeizhu;
    }

    public void setRbeizhu(int rbeizhu) {
        this.rbeizhu = rbeizhu;
    }
}
