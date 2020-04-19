package com.lyh1.test;

import com.lyh1.domain.Account;
import com.lyh1.util.DaoUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionTest {
    public static void main(String[] args) throws Exception {

        String sql;
        PreparedStatement ps;
        Connection conn;
        String name = "ls";

        //查询ls额度
        conn = DaoUtil.getConn();
        assert conn != null;
        sql = "select * from account where name=? and money>?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setBigDecimal(2, BigDecimal.valueOf(1000));
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            Account acc = new Account();
            acc.setMoney(rs.getInt("money"));
            acc.setName(rs.getString("name"));
            System.out.println(acc);
        }else{
            throw new RuntimeException("余额不足");
        }



        try{
            //减少ls账户的额度
            //开启事务，关闭自动提交
            conn.setAutoCommit(false);
            sql = "update account set money=money-? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1000);
            ps.setString(2,name);
            int row = ps.executeUpdate();
            System.out.println(row);
//            int a = 1/0;
            //增加zs账户额度
            sql = "update account set money=money+? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1000);
            ps.setString(2,"zs");
            int r = ps.executeUpdate();
            System.out.println(r);

            //提交事务
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            DaoUtil.Daoclose(null,ps,conn);
        }

    }

}
