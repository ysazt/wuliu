package com.wuliu.dao;

import com.mysql.jdbc.Driver;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

    public Connection getCon(){

        try {
             Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/wuliu?useUnicode=true&characterEncoding=utf8";
            String mysqlname="root";
            String mysqlpwd="";
            Connection con = DriverManager.getConnection(url,mysqlname,mysqlpwd);
            return con ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        PrintStream pst = System.out;
        pst.println();
        return null ;
    }
}
