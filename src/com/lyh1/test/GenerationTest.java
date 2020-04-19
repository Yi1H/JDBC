package com.lyh1.test;

import com.lyh1.util.DaoUtil;

import java.sql.*;

public class GenerationTest {
    public static void main(String[] args) throws Exception {
        Connection conn = DaoUtil.getConn();
        String sql = "insert into stu(age,name) values(?,?)";
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,40);
        ps.setString(2,"zs");
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()){

            System.out.println(rs.getInt(1));
        }

    }
    void stm() throws Exception {

        Connection conn = DaoUtil.getConn();
        String sql = "insert into stu(age,name) values(30,'ls')";
        assert conn != null;
        Statement stm = conn.createStatement();
        stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet gk = stm.getGeneratedKeys();
        if (gk.next()){

            System.out.println(gk.getInt(1));
        }
    }
}
