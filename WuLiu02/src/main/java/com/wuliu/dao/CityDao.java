package com.wuliu.dao;

import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.serivce.CityService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends BaseDao {
    ProvinceDao provinceDao = new ProvinceDao();

    public void addCityDao(CityEntity cityEntity){
        try {
            String sql = "insert into db_city values (null,?,?)";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,cityEntity.getCname());
            pst.setInt(2,cityEntity.getCproid().getPid());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delCityDao(int id){
        try {
            String sql ="delete from db_city where cid=?"  ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCityDao(int id , String cname){
        try {
            String sql ="update db_city set cname=? where cid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,cname);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 根据城市的主键返回当前对象
    public CityEntity byidCityDao(int cid){
        CityEntity cityEntity = null;
        try {
            String sql ="select * from db_city where cid=?";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setInt(1,cid);
            ResultSet rs = st.executeQuery() ;
            if (rs.next()){
                cityEntity = new CityEntity();
                cityEntity.setCid(rs.getInt(1));
                cityEntity.setCname(rs.getString(2));
                int prid = rs.getInt(3);
                ProvinceEntity provinceEntity = provinceDao.byidProvinceDao(prid);
                cityEntity.setCproid(provinceDao.byidProvinceDao(prid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityEntity ;
    }

    //根据省份id 和城市名 ，返回城市id
    public int bynameAndPidCityDao(int proid,String cname){
       int cid = 0 ;
        try {
            String sql ="select * from db_city where cname=? and cproid=?";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setString(1,cname);
            st.setInt(2,proid);
            ResultSet rs = st.executeQuery() ;
            if (rs.next()){
                cid =rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cid ;
    }

    // 根据省份的id ，返回省份id对应的所有城市
    public List<CityEntity> allCityByProidDao(int proid){
        List<CityEntity> list = new ArrayList<>();
        try {
            String sql ="select * from db_city where cproid=?";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setInt(1,proid);
            ResultSet rs = st.executeQuery() ;
            while (rs.next()){
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCid(rs.getInt(1));
                cityEntity.setCname(rs.getString(2));
                int prid = rs.getInt(3);
                cityEntity.setCproid(provinceDao.byidProvinceDao(prid));
                list.add(cityEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    public List<CityEntity> allCityDao(){
           List<CityEntity> list = new ArrayList<>();
        try {
            String sql="select * from db_city";
            PreparedStatement pst = getCon().prepareStatement(sql) ;
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCid(rs.getInt(1));
                cityEntity.setCname(rs.getString(2));
                cityEntity.setCproid(provinceDao.byidProvinceDao(rs.getInt(3)));
                list.add(cityEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }


    public List<CityEntity> allCityDao3(){
        List<CityEntity> list = new ArrayList<>();
        try {
            String sql="select * from db_city ORDER BY cproid ";
            PreparedStatement pst = getCon().prepareStatement(sql) ;
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCid(rs.getInt(1));
                cityEntity.setCname(rs.getString(2));
                cityEntity.setCproid(provinceDao.byidProvinceDao(rs.getInt(3)));
                list.add(cityEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    public List<CityEntity> allCityDao1(){
        List<CityEntity> list = new ArrayList<>();
        try {
            String sql="select cid,cname,pid,pname from db_city c, db_province  p  where c.cproid = p.pid";
            PreparedStatement pst = getCon().prepareStatement(sql) ;
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CityEntity cityEntity = new CityEntity();
                cityEntity.setCid(rs.getInt(1));
                cityEntity.setCname(rs.getString(2));
                ProvinceEntity pro = new ProvinceEntity();
                pro.setPid(rs.getInt(3));
                pro.setPname(rs.getString(4));
                cityEntity.setCproid(pro);
                list.add(cityEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    // 根据省id +城市id  返回对应的名字
    public String bycidAndpidCityDao(int cid , int pid){
        String str = null;
        try {
            String sql ="select pname,cname from db_city c, db_province p where c.cproid = p.pid  and c.cid=?  and p.pid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,cid);
            pst.setInt(2,pid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                str = rs.getString(1)+" "+rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str ;
    }

    public int byNameUser(String name){
        try {
            String sql ="select cid from db_city where cname=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,name);
            // return !pst.executeQuery().next();//
            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0 ;
    }

}
