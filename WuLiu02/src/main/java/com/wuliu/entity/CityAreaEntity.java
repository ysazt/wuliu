package com.wuliu.entity;

public class CityAreaEntity {
    private int aid ;
    private String aname ;
    private CityEntity acid ;

    public CityAreaEntity() {
    }

    public CityAreaEntity(int aid, String aname, CityEntity acid) {
        this.aid = aid;
        this.aname = aname;
        this.acid = acid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public CityEntity getAcid() {
        return acid;
    }

    public void setAcid(CityEntity acid) {
        this.acid = acid;
    }

    @Override
    public String toString() {
        return "CityAreaEntity{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", acid=" + acid +
                '}';
    }
}
