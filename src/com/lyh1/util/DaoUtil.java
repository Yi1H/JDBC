package com.lyh1.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DaoUtil {
    //运用配置文件导入
//    public static String url = "jdbc:mysql://localhost/jdbc";
//    public static String user = "root";
//    public static String pass = "123456";
//    public static String drivername = "com.mysql.jdbc.Driver";


//    static {
//        //运用bdcp连接池来创建connection
//        bds = new BasicDataSource();
//        bds.setDriverClassName(drivername);
//        bds.setUrl(url);
//        bds.setUsername(user);
//        bds.setPassword(pass);
//    }

    public static DataSource bds = null;
    static {
        try {
            Properties p = new Properties();
            FileInputStream in = new FileInputStream("src/resource/db.properties");
            p.load(in);
//            bds = BasicDataSourceFactory.createDataSource(p);
            bds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //建立数据库连接
//    public static Connection getConn()  {
//        //加载驱动
//        try {
//            Class.forName(drivername);
//            //建立数据库连接
//            return DriverManager.getConnection(url, user, pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    //建立数据库连接
    public static Connection getConn()  {
        //加载驱动
        try {
            //建立数据库连接
            return bds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }

    //关闭资源
    public static void Daoclose(ResultSet res, Statement stm, Connection conn) {
        try {
            if (res!=null)
                res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            if (stm != null){
                stm.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
