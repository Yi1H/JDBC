package com.lyh2.dao;

import com.lyh2.domain.Student;

import java.util.List;

public interface IStudentDao {
    //保存学员信息
    public void save(Student stu);
    //删除学员信息
    void del(int ids);
    //修改学员信息
    void update(Student stu);

    //查询指定学员信息
    Student get(int id) ;
    //查询所有学员信息
    List<Student> getAll();
    //查询学生总数
    Integer getCount();
}
