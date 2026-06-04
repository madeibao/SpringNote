package com.example.demo.service;

import com.example.demo.base.service.BaseService;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @ClassName StudentService
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:43
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class StudentService extends BaseService<Student, StudentMapper> {

}
