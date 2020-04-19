package com.lyh1.test;

import com.lyh1.util.DaoUtil;

import java.sql.*;

public class procedureTest {
    @org.junit.jupiter.api.Test
    void procedure() throws Exception {
        //单参数存储过程调用
        //建立数据库连接
//        Connection conn = DaoUtil.getConn();
        //调用存储过程
//        assert conn != null;
//        CallableStatement cs = conn.prepareCall("{ call getStu(?) }");
        //设置参数
//        cs.setString(1,"林ba");
        //执行存储过程
//        ResultSet rs = cs.executeQuery();
//        if (rs.next()){
//            Student stu = new Student();
//            stu.setAge(rs.getInt("age"));
//            stu.setId(rs.getInt("id"));
//            stu.setName(rs.getString("name"));
//            System.out.println(stu);

        //建立数据库连接
        Connection conn = DaoUtil.getConn();
        //调用存储过程
        assert conn != null;
        CallableStatement cs = conn.prepareCall("{ call getName(?,?) }");
        //设置参数
        cs.setInt(1,30);
        cs.registerOutParameter(2, Types.VARCHAR);
        //执行操作
        cs.execute();

        String name = cs.getString(2);
        System.out.println(name);


        }

    }

