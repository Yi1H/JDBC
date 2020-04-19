package com.lyh2.dao.impl;

import com.lyh2.handle.BeanHandle;
import com.lyh2.handle.BeanListHandle;
import com.lyh2.handle.CountResultSetImp;
import com.lyh2.util.CUDRTemplate;
import com.lyh2.dao.IStudentDao;
import com.lyh2.domain.Student;
import java.util.List;

public class StudentDaoImple implements IStudentDao {

    @Override
    public void save(Student stu)  {
        String sql = "insert into stu(id,name,age) values(?,?,?)";
        CUDRTemplate.dml(sql,stu.getId(),stu.getName(),stu.getAge());
    }

    @Override
    public void del(int id) {
        String sql = "delete from stu where id=?";
        CUDRTemplate.dml(sql,id);
    }

    @Override
    public void update(Student stu) {
        String sql = "update stu set age=?,name=? where id=?";
        CUDRTemplate.dml(sql,stu.getAge(), stu.getName(),stu.getId());
    }

    @Override
    public Student get(int id) {
        String sql = "Select * from stu where id=?";
        return CUDRTemplate.dql(sql, new BeanHandle<>(Student.class),id);
    }

    @Override
    public List<Student> getAll() {
        String sql = "Select * from stu ";
        return CUDRTemplate.dql(sql,new BeanListHandle<>(Student.class));
    }

    @Override
    public Integer getCount() {
        String sql = "select count(*) as count from stu";
        return CUDRTemplate.dql(sql,new CountResultSetImp());
    }
}
