package com.wuliu.entity;

public class UserEntity {
    private int uid ;
    private String uname ;
    private String upwd ;
    private String usex;
    private String uphone;
    private String uaddress ;// 区
    private String ubirthday ;
    private String ucity ; //城市
    private String utime ;
    private int uflag ; //1. 消费者 0.管理员
    private int ubeizhu; //0.账户可用  1. 账户不可用

    private String ucode ;

    public UserEntity() {
    }

    public UserEntity(String uname, String upwd, String usex, String uphone, String uaddress, String ubirthday, String ucity, String utime, int uflag, int ubeizhu) {
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.uphone = uphone;
        this.uaddress = uaddress;
        this.ubirthday = ubirthday;
        this.ucity = ucity;
        this.utime = utime;
        this.uflag = uflag;
        this.ubeizhu = ubeizhu;
    }

    public UserEntity(int uid, String uname, String upwd, String usex, String uphone, String uaddress, String ubirthday, String ucity, String utime, int uflag, int ubeizhu) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.uphone = uphone;
        this.uaddress = uaddress;
        this.ubirthday = ubirthday;
        this.ucity = ucity;
        this.utime = utime;
        this.uflag = uflag;
        this.ubeizhu = ubeizhu;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(String ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public int getUflag() {
        return uflag;
    }

    public void setUflag(int uflag) {
        this.uflag = uflag;
    }

    public int getUbeizhu() {
        return ubeizhu;
    }

    public void setUbeizhu(int ubeizhu) {
        this.ubeizhu = ubeizhu;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex='" + usex + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", ubirthday='" + ubirthday + '\'' +
                ", ucity='" + ucity + '\'' +
                ", utime='" + utime + '\'' +
                ", uflag=" + uflag +
                ", ubeizhu=" + ubeizhu +
                '}';
    }
}
