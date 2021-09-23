package com.wuliu.dao;

import com.wuliu.entity.ProvinceEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao extends BaseDao {

    //增删改查
    public void addProviceDao(String name ){
        try {
            String sql ="insert into db_province values(null,?)";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delProvinceDao(int id){
        try {
            String sql ="delete from db_province where pid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,id);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProvinceDao(ProvinceEntity provinceEntity){
        try {
            String sql="update db_province set pname= ? where pid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,provinceEntity.getPname());
            pst.setInt(2,provinceEntity.getPid());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // 根据省份id ,返回省份对象
    public ProvinceEntity byidProvinceDao(int id ){
       ProvinceEntity provinceEntity = null ;
        try {
            String sql ="select * from db_province where pid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                provinceEntity = new ProvinceEntity();
                provinceEntity.setPid(rs.getInt(1));
                provinceEntity.setPname(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  provinceEntity ;
    }
    // 根据省份名字，返回省份对象
    public ProvinceEntity bynameProvinceDao(String name ){
        ProvinceEntity provinceEntity = null ;
        try {
            String sql ="select * from db_province where pname=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                provinceEntity = new ProvinceEntity();
                provinceEntity.setPid(rs.getInt(1));
                provinceEntity.setPname(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  provinceEntity ;
    }

    public List<ProvinceEntity> allProvinceDao(){
        List<ProvinceEntity> list = new ArrayList();
        try {
            String sql ="select * from db_province ";
            PreparedStatement pst = getCon().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ProvinceEntity provinceEntity = new ProvinceEntity();
                provinceEntity.setPid(rs.getInt(1));
                provinceEntity.setPname(rs.getString(2));
                list.add(provinceEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list ;
    }

    public int totalProvinceDao(){
        int total = 0 ;
        try {
            String sql ="select count(*)  from db_province ";
            PreparedStatement pst = getCon().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total   ;
    }

    public List<ProvinceEntity> allProvinceByPageDao(int startIndex, int pageNum){
        List<ProvinceEntity> list = new ArrayList();
        try {
            String sql ="select * from db_province limit ?,?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,startIndex);
            pst.setInt(2,pageNum);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ProvinceEntity provinceEntity = new ProvinceEntity();
                provinceEntity.setPid(rs.getInt(1));
                provinceEntity.setPname(rs.getString(2));
                list.add(provinceEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list ;
    }
}
