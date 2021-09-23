package com.wuliu.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeifanDao extends  BaseDao {

    public double byfcidPeifanDao(int fcid){
        try {
            String sql="select fprice from db_peifan where fcid=?";
           PreparedStatement pst = getCon().prepareStatement(sql);
           pst.setInt(1,fcid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return 0 ;
    }
}
