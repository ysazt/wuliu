package com.wuliu.entity;

import java.util.List;

public class CityCenterEnity {
    private String cproname ;
    private int num ;
    private List<CityEntity> list ;


    public String getCproname() {
        return cproname;
    }

    public void setCproname(String cproname) {
        this.cproname = cproname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<CityEntity> getList() {
        return list;
    }

    public void setList(List<CityEntity> list) {
        this.list = list;
    }
}
