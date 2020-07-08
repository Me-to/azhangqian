package com.example.demo;


import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    StudentController controller;

    @Autowired
    StudentService studentService;

//    @Test
//    public void test1() {
//        Student student = controller.queryById(1);
//        System.out.println(student);
//    }

    @Test
    public void test2() {
        List<Student> list = studentService.queryAllByLimit(1, 1);
        System.out.println(list);
    }

    @Test
    public void insert() {
        Student student = new Student();
        student.setAge(18);
        student.setName("小王");
        student.setNumber("12");
        student.setSex("女");
        controller.insertStudent(student);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(12);
        student.setName("修改1111");
        studentService.update(student);
    }

    @Test
    public void del() {
        studentService.deleteById(1);
    }


}
