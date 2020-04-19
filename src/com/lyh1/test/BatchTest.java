package com.lyh1.test;

import com.lyh1.util.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class BatchTest {
    public static void main(String[] args) throws Exception {
        //批处理存在的问题，已添加rewriteBatchedStatements=true参数但没有效果，但是添加conn.setAutoCommit(false)能执行更快
        Connection conn = DaoUtil.getConn();
        String sql = "insert into stu(age,name) value(?,?)";
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement(sql);
//        conn.setAutoCommit(false);
        long start = System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            ps.setInt(1,15);
            ps.setString(2,"zsr");
            ps.addBatch();
        }
        ps.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        DaoUtil.Daoclose(null,ps,conn);
    }
}
