package com.wuliu.dao;

import com.wuliu.entity.CityEntity;
import com.wuliu.entity.RoutineEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoutineDao extends BaseDao {

   /* public void addRoutineDao(RoutineEntity routineEntity){

        try {
            String sql="" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    public void addRoutineDao(RoutineEntity routineEntity){
        try {
            String sql="insert into db_routine values (null,?,?,?,?,?)" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,routineEntity.getRname());
            pst.setInt(2,routineEntity.getRbegincid().getCid());
            pst.setInt(3,routineEntity.getRendcid().getCid());
            pst.setDouble(4,routineEntity.getRprice());
            pst.setInt(5,routineEntity.getRbeizhu());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delRoutineDao(int id,int flag){
        try {
            String sql="update db_routine set rbeizhu=? where rid=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,flag);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRoutineDao(double newPrice ,int rid){
        try {
            String sql="update db_routine set rprice=? where rid=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setDouble(1,newPrice);
            pst.setInt(2,rid);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isCheckBeginAndEnd(int bid,int eid){
        try {
            String sql="select * from db_routine where rbegincid=? and rendcid=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,bid);
            pst.setInt(2,eid);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public RoutineEntity byidRoutineDao(int rid){
        RoutineEntity routineEntity = null ;
        try {
            String sql="select * from db_routine where rid=? and rbeizhu=0" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,rid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                routineEntity = new RoutineEntity();
                routineEntity.setRid(rs.getInt(1));
                routineEntity.setRname(rs.getString(2));
                CityEntity beginCity = new CityDao().byidCityDao(rs.getInt(3));
                routineEntity.setRbegincid(beginCity);
                CityEntity endCity = new CityDao().byidCityDao(rs.getInt(4));
                routineEntity.setRendcid(endCity);
                routineEntity.setRprice(rs.getDouble(5));
                routineEntity.setRbeizhu(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routineEntity;
    }

    public RoutineEntity byidRoutineDao1(int rid){
        RoutineEntity routineEntity = null ;
        try {
            String sql="select rid, rname , rbegincid, c.cname cbeginname , rendcid, c1.cname cendname, rprice,rbeizhu  from db_routine r, db_city c,db_city c1 where r.rbegincid = c.cid and r.rendcid = c1.cid and rid=? and rbeizhu=0" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,rid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                routineEntity = new RoutineEntity();
                routineEntity.setRid(rs.getInt(1));
                routineEntity.setRname(rs.getString(2));
                CityEntity beginCity = new CityEntity();
                beginCity.setCid(rs.getInt(3));
                beginCity.setCname(rs.getString(4));
                routineEntity.setRbegincid(beginCity);
                CityEntity endCity = new CityEntity();
                endCity.setCid(rs.getInt(5));
                endCity.setCname(rs.getString(6));
                routineEntity.setRendcid(endCity);
                routineEntity.setRprice(rs.getDouble(7));
                routineEntity.setRbeizhu(rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routineEntity;
    }

    public List<RoutineEntity> allRoutineDao(int beizhu){
        List<RoutineEntity> list = new ArrayList<>();
        try {
            String sql="select rid, rname , rbegincid, c.cname cbeginname , rendcid, c1.cname cendname, rprice,rbeizhu  from db_routine r, db_city c,db_city c1 where r.rbegincid = c.cid and r.rendcid = c1.cid and rbeizhu=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,beizhu);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                RoutineEntity   routineEntity = new RoutineEntity();
                routineEntity.setRid(rs.getInt(1));
                routineEntity.setRname(rs.getString(2));
                CityEntity beginCity = new CityEntity();
                beginCity.setCid(rs.getInt(3));
                beginCity.setCname(rs.getString(4));
                routineEntity.setRbegincid(beginCity);
                CityEntity endCity = new CityEntity();
                endCity.setCid(rs.getInt(5));
                endCity.setCname(rs.getString(6));
                routineEntity.setRendcid(endCity);
                routineEntity.setRprice(rs.getDouble(7));
                routineEntity.setRbeizhu(rs.getInt(8));

                list.add(routineEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<RoutineEntity> allbyCbeginidRoutineDao(int cbeginid){
        List<RoutineEntity> list = new ArrayList<>();
        try {
            String sql="select rid, rname , rbegincid, c.cname cbeginname , rendcid, c1.cname cendname, rprice,rbeizhu  from db_routine r, db_city c,db_city c1 where r.rbegincid = c.cid and r.rendcid = c1.cid and rbegincid=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,cbeginid);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                RoutineEntity   routineEntity = new RoutineEntity();
                routineEntity.setRid(rs.getInt(1));
                routineEntity.setRname(rs.getString(2));
                CityEntity beginCity = new CityEntity();
                beginCity.setCid(rs.getInt(3));
                beginCity.setCname(rs.getString(4));
                routineEntity.setRbegincid(beginCity);
                CityEntity endCity = new CityEntity();
                endCity.setCid(rs.getInt(5));
                endCity.setCname(rs.getString(6));
                routineEntity.setRendcid(endCity);
                routineEntity.setRprice(rs.getDouble(7));
                routineEntity.setRbeizhu(rs.getInt(8));

                list.add(routineEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public double byCbeginidAndCendidRoutineDao(int cbeginid,int cendid){
        try {
            String sql="select  rprice  from db_routine  where rendcid = ? and rbegincid=?" ;
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,cendid);
            pst.setInt(2,cbeginid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
