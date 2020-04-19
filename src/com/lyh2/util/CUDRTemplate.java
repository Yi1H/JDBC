package com.lyh2.util;

import com.lyh2.handle.IResultSetHandle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CUDRTemplate {
    //重构DML操作代码
    public static void dml(String sql, Object...params){
        Connection conn = null;
        PreparedStatement ppS = null;
        try{
            conn = DaoUtil.getConn();
            assert conn != null;
            ppS = conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                ppS.setObject(i+1,params[i]);
            }
            ppS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(null,ppS,conn);
        }
    }
    //重构DQL操作
    public static <T>T dql(String sql, IResultSetHandle<T> rs, Object...params){
        ResultSet res = null;
        Connection conn = null;
        Statement stm = null;
        try{
            conn = DaoUtil.getConn();
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            //执行sql语句
            res = ps.executeQuery();
            return rs.IHandle(res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(res,stm,conn);
        }
        return null;
    }
}
