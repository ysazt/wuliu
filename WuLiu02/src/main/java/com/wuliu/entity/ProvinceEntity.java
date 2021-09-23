package com.wuliu.entity;

public class ProvinceEntity {

    private int pid ;
    private String pname ;

    public ProvinceEntity() {
    }

    public ProvinceEntity(String pname) {
        this.pname = pname;
    }

    public ProvinceEntity(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    //修改的用， 将用户的值封装到了这个类中 ，
    public int getPid() {
        return pid;
    }

    // 查询， 将数据库中的值封装到了这个类中
    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "ProvinceEntity{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
