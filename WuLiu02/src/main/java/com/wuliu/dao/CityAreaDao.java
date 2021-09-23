package com.wuliu.dao;

import com.wuliu.entity.CityAreaEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityAreaDao extends  BaseDao {
    CityDao cityDao = new CityDao();

    public List<CityAreaEntity> allByCidDao(int acid ){
        List<CityAreaEntity> list = new ArrayList<>();
        try {
            String sql ="select * from db_cityarea where acid=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setInt(1,acid);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                CityAreaEntity cityAreaEntity = new CityAreaEntity();
                cityAreaEntity.setAid(rs.getInt(1));
                cityAreaEntity.setAname(rs.getString(2));
                cityAreaEntity.setAcid(cityDao.byidCityDao(rs.getInt(3)));
                list.add(cityAreaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }
}
