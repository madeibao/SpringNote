package com.example.demo.web;

import com.example.demo.base.web.BaseController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName StudentController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:45
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("student")
public class StudentController extends BaseController<StudentService, Student> {

    @Override
    public  String getPerfix(){
        return  "/student";
    }


}