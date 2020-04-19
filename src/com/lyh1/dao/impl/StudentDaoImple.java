package com.lyh1.dao.impl;

import com.lyh1.dao.IStudentDao;
import com.lyh1.domain.Student;
import com.lyh1.util.DaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImple implements IStudentDao {

    @Override
    public void save(Student stu)  {
        Statement stm = null;
        Connection conn = null;
        PreparedStatement ppS = null;
        try{
            conn = DaoUtil.getConn();
            //获取数据
            Integer age = stu.getAge();
            Integer id = stu.getId();
            String name = stu.getName();

            //创建（静态）sql语句
//            String sql = "insert into stu values("+id+",'"+name+"',"+age+")";
//            assert conn != null;
//            stm = conn.createStatement();
            //执行sql语句
//            int res = stm.executeUpdate(sql);

            //运用预编sql语句
            String sql = "insert into stu(id,name,age) values(?,?,?)";
            assert conn != null;
            ppS = conn.prepareStatement(sql);
            //预编sql语句中的值
            ppS.setInt(1,id);
            ppS.setString(2,name);
            ppS.setInt(3,age);
            int row = ppS.executeUpdate();
            System.out.println(row);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(null,ppS,conn);
        }

    }

    @Override
    public void del(int id) {
        Statement stm = null;
        Connection conn = null;
        PreparedStatement ppS = null;
        try{
            conn = DaoUtil.getConn();
            //创建sql语句
//            String sql = "delete from stu where id="+ids+"";
//            assert conn != null;
//            stm = conn.createStatement();
//            //执行sql语句
//            int res = stm.executeUpdate(sql);
//            System.out.println(res);

            //运用预编sql语句
            String sql = "delete from stu where id=?";
            assert conn != null;
            ppS = conn.prepareStatement(sql);
            ppS.setInt(1,id);
            int row = ppS.executeUpdate();
            System.out.println(row);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(null,ppS,conn);
        }
    }

    @Override
    public void update(Student stu) {
        Statement stm = null;
        Connection conn = null;
        PreparedStatement ppS = null;
        try{
            conn = DaoUtil.getConn();
            //获取数据
            Integer age = stu.getAge();
            Integer id = stu.getId();
            String name = stu.getName();

            //创建sql语句
//            String sql = "update stu set age="+age+",name='"+name+"' where id="+id+"";
//            assert conn != null;
//            stm = conn.createStatement();
            //执行sql语句
//            int res = stm.executeUpdate(sql);
//            System.out.println(res);

            //运用预编sql语句
            String sql = "update stu set age=?,name=? where id=?";
            assert conn != null;
            ppS = conn.prepareStatement(sql);
            ppS.setInt(1,age);
            ppS.setString(2,name);
            ppS.setInt(3,id);
            int row = ppS.executeUpdate();
            System.out.println(row);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(null,ppS,conn);
        }
    }

    @Override
    public Student get(int id) {
        Student stu = null;
        ResultSet res = null;
        PreparedStatement ppS = null;
        Connection conn = null;
        try{
            conn = DaoUtil.getConn();
            //创建sql语句
            String sql = "Select * from stu where id=?";
            assert conn != null;
            ppS = conn.prepareStatement(sql);
            ppS.setInt(1,id);

            //执行sql语句
            res = ppS.executeQuery();
            if (res.next()){
                stu  = new Student();
                stu.setAge(res.getInt("age"));
                stu.setName(res.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(res,ppS,conn);
        }
        return stu;
    }

    @Override
    public List<Student> getAll() {
        Student stu;
        ResultSet res = null;
        Connection conn = null;
        List<Student> list = new ArrayList<Student>();
        Statement stm = null;
        try{
            conn = DaoUtil.getConn();
            //创建sql语句
            String sql = "Select * from stu ";
            assert conn != null;
            stm = conn.createStatement();
            //执行sql语句
            res = stm.executeQuery(sql);
            while (res.next()){
                stu  = new Student();
                stu.setAge(res.getInt("age"));
                stu.setName(res.getString("name"));
                list.add(stu);
            }
//            System.out.println(res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DaoUtil.Daoclose(res,stm,conn);
        }
        return list;
    }
}
