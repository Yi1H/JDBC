package com.lyh2.test;

import com.lyh2.dao.impl.StudentDaoImple;
import com.lyh2.domain.Student;
import org.junit.jupiter.api.Test;


class StudentDaoImpleTest {

    @org.junit.jupiter.api.Test
    void save() {
        StudentDaoImple studao = new StudentDaoImple();
        Student stu = new Student();
        stu.setId(16);
        stu.setName("lin爸");
        stu.setAge(22);
        studao.save(stu);
    }

    @org.junit.jupiter.api.Test
    void del() {
        StudentDaoImple studao = new StudentDaoImple();
        studao.del(2);
    }

    @org.junit.jupiter.api.Test
    void update() {
        StudentDaoImple studao = new StudentDaoImple();
        Student stu = new Student();
        stu.setId(15);
        stu.setName("nihaoh");
        stu.setAge(21);
        studao.update(stu);
    }

    @org.junit.jupiter.api.Test
    void get() {
        StudentDaoImple studao = new StudentDaoImple();
        System.out.println(studao.get(15));
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        StudentDaoImple studao = new StudentDaoImple();
        System.out.println(studao.getAll());
    }

    @Test
    void getCount(){
        StudentDaoImple studao = new StudentDaoImple();
        System.out.println(studao.getCount());
    }
}
