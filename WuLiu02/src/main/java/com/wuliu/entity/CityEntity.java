package com.wuliu.entity;

public class CityEntity {
    private int cid ;
    private String cname ;
    private ProvinceEntity cproid;

    public CityEntity() {
    }

    public CityEntity(int cid) {
        this.cid = cid;
    }

    public CityEntity(int cid, String cname, ProvinceEntity cproid) {
        this.cid = cid;
        this.cname = cname;
        this.cproid = cproid;
    }

    public CityEntity(String cname, ProvinceEntity cproid) {
        this.cname = cname;
        this.cproid = cproid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public ProvinceEntity getCproid() {
        return cproid;
    }

    public void setCproid(ProvinceEntity cproid) {
        this.cproid = cproid;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cproid=" + cproid +
                '}';
    }
}
