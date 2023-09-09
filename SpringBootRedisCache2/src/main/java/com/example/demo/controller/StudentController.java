package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName StudentController
 * @Author：Mayuan
 * @Date 2023/9/8/0008 11:26
 * @Description TODO
 * @Version 1.0
 **/
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
