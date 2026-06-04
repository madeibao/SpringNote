package com.example.demo.mapper;

/**
 * @ClassName StudentMapper
 * @Author：Mayuan
 * @Date 2023/9/8/0008 11:26
 * @Description TODO
 * @Version 1.0
 **/

import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> findAll();
}