package com.lyh1.test;

import com.lyh1.util.DaoUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;


public class poolTest {
    public static void main(String[] args) throws Exception {
        //运用DBCP连接池连接数据库
        Connection conn = DaoUtil.getConn();
        String sql = "delete from stu where id=?";
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,20);
        int row = ps.executeUpdate();
        System.out.println(row);

        DaoUtil.Daoclose(null,ps,conn);
    }
}
