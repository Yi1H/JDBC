package com.lyh1.test;

import com.lyh1.dao.impl.StudentDaoImple;
import com.lyh1.domain.Student;

import java.util.List;

class StudentDaoImpleTest {

    @org.junit.jupiter.api.Test
    void save() {
        StudentDaoImple studao = new StudentDaoImple();
        Student stu = new Student();
        stu.setId(15);
        stu.setName("林baba");
        stu.setAge(20);
        studao.save(stu);
    }

    @org.junit.jupiter.api.Test
    void del() {
        StudentDaoImple studao = new StudentDaoImple();
        studao.del(20);
    }

    @org.junit.jupiter.api.Test
    void update() {
        StudentDaoImple studao = new StudentDaoImple();
        Student stu = new Student();
        stu.setId(30);
        stu.setName("林爸ba");
        stu.setAge(21);
        studao.update(stu);
    }

    @org.junit.jupiter.api.Test
    void get() {
        StudentDaoImple studao = new StudentDaoImple();
        Student stu = studao.get(30);
        System.out.println(stu);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        StudentDaoImple studao = new StudentDaoImple();
        List list = studao.getAll();
        System.out.println(list);
    }
}
