package com.wuliu.dao;

import com.wuliu.entity.UserEntity;
import com.wuliu.utils.Tools;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends  BaseDao {

    //增加  , 需要形参， 返回值int 或者void
    public void addUserDao(UserEntity userEntity){
        try {
            //insert into db_user values (null,'admin','123','男','15047204310','济南市','199909','长清区','2021-08-26 15:12:23',0,0)
            String sql ="insert into db_user values (null,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,userEntity.getUname());
            pst.setString(2,userEntity.getUpwd());
            pst.setString(3,userEntity.getUsex());
            pst.setString(4,userEntity.getUphone());
            pst.setString(5,userEntity.getUaddress());
            pst.setString(6,userEntity.getUbirthday());
            pst.setString(7,userEntity.getUcity());
            pst.setString(8,userEntity.getUtime());
            pst.setInt(9,userEntity.getUflag());
            pst.setInt(10,userEntity.getUbeizhu());
            pst.setString(11,userEntity.getUcode());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUserDao(int id){
        try {
            //insert into db_user values (null,'admin','123','男','15047204310','济南市','199909','长清区','2021-08-26 15:12:23',0,0)
            String sql ="update db_user set ubeizhu=0 where uid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //重名判断  你的值已经在库里有了  , 有值返回false ,无值返回true
    public boolean isCheckName(String name){
        try {
            String sql ="select * from db_user where uname=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
           // return !pst.executeQuery().next();//
           ResultSet rs =  pst.executeQuery();
           boolean result = rs.next();
           boolean fan = ! result;
           return fan;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true ;
    }



    public int lastUserId(){
        int id =0;
        try {
            String sql ="select * from db_user ORDER BY uid desc  ";
            PreparedStatement pst = getCon().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ // 若执行if 体内 ， 则表示查询到了结果， 就会进行实例化UserEntity
               id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  id ;
    }

    public int byCodeUser(String code){
        int id =0;
        try {
            String sql ="select * from db_user where ucode=?  ";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,code);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ // 若执行if 体内 ， 则表示查询到了结果， 就会进行实例化UserEntity
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  id ;
    }


    //登录

    /*
    * 若前台： 就传来了， 用户名和密码， 要求用户名不能重复 ，--》唯一的对象中，flag ， 根据你的flag 跳转到不同的页面
    *                    用户名和密码，flag    select * from db_user where uname=? and upwd=? and flag=? -->唯一对象，备注字段若是不可用，照样不能登录成
    *                                          select * from db_user where uname=? and upwd=? and uflag=?  and  ubeizhu=0
    * */
    //根据用户名、密码、flag 返回对象
    public UserEntity loginUserDao2(String name ,String pwd,int flag){
        UserEntity userEntity = null;
        try {
            String sql ="select * from db_user where uname=? and upwd=? and uflag=? and ubeizhu=0";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,pwd);
            pst.setInt(3,flag);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ // 若执行if 体内 ， 则表示查询到了结果， 就会进行实例化UserEntity
                userEntity = new UserEntity();
                userEntity.setUid(rs.getInt(1));
                userEntity.setUname(rs.getString(2));
                userEntity.setUpwd(rs.getString(3));
                userEntity.setUsex(rs.getString(4));
                userEntity.setUphone(rs.getString(5));
                userEntity.setUaddress(rs.getString(6));
                userEntity.setUbirthday(rs.getString(7));
                userEntity.setUcity(rs.getString(8));
                userEntity.setUtime(rs.getString(9));
                userEntity.setUflag(rs.getInt(10));
                userEntity.setUbeizhu(rs.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userEntity ;
    }

    //根据用户名、密码、flag 返回对象  ，这个方法需要service继续处理
    public UserEntity loginUserDao1(String name ,String pwd,int flag){
        UserEntity userEntity = null;
        try {
            String sql ="select * from db_user where uname=? and upwd=? and uflag=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,pwd);
            pst.setInt(3,flag);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ // 若执行if 体内 ， 则表示查询到了结果， 就会进行实例化UserEntity
                userEntity = new UserEntity();
                userEntity.setUid(rs.getInt(1));
                userEntity.setUname(rs.getString(2));
                userEntity.setUpwd(rs.getString(3));
                userEntity.setUsex(rs.getString(4));
                userEntity.setUphone(rs.getString(5));
                userEntity.setUaddress(rs.getString(6));
                userEntity.setUbirthday(rs.getString(7));
                userEntity.setUcity(rs.getString(8));
                userEntity.setUtime(rs.getString(9));
                userEntity.setUflag(rs.getInt(10));
                userEntity.setUbeizhu(rs.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userEntity ;
    }

    // service 判断
    public UserEntity loginUserDao(String name ,String pwd){
        UserEntity userEntity = null;
        try {
            String sql ="select * from db_user where uname=? and upwd=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ // 若执行if 体内 ， 则表示查询到了结果， 就会进行实例化UserEntity
               userEntity = new UserEntity();
               userEntity.setUid(rs.getInt(1));
                userEntity.setUname(rs.getString(2));
                userEntity.setUpwd(rs.getString(3));
                userEntity.setUsex(rs.getString(4));
                userEntity.setUphone(rs.getString(5));
                userEntity.setUaddress(rs.getString(6));
                userEntity.setUbirthday(rs.getString(7));
                userEntity.setUcity(rs.getString(8));
                userEntity.setUtime(rs.getString(9));
                userEntity.setUflag(rs.getInt(10));
                userEntity.setUbeizhu(rs.getInt(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userEntity ;
    }

}
