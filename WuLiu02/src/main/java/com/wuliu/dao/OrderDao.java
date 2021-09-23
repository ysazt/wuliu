package com.wuliu.dao;

import com.wuliu.entity.OrderEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao extends BaseDao {

    public void addOrder(OrderEntity orderEntity){
        try {
            String sql="insert into db_order values (null,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setString(1,orderEntity.getDname());
            pst.setDouble(2,orderEntity.getDweight());
            pst.setString(3,orderEntity.getDbname());
            pst.setString(4,orderEntity.getDbaddr());
            pst.setString(5,orderEntity.getDbphone());
            pst.setString(6,orderEntity.getDrname());
            pst.setString(7,orderEntity.getDraddr());
            pst.setString(8,orderEntity.getDrphone());
            pst.setString(9,orderEntity.getDtime());
            pst.setDouble(10,orderEntity.getDprice());
            pst.setInt(11,orderEntity.getDflag());
            pst.setString(12,orderEntity.getDbeizhu());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改  price  flag  根据备注
    public void updateOrder(double price , int flag , String code){
        try {
            String sql ="update db_order set dprice=?,dflag=? where dbeizhu=?";
            PreparedStatement pst = getCon().prepareStatement(sql);
            pst.setDouble(1,price);
            pst.setInt(2,flag);
            pst.setString(3,code);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
