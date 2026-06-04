package com.example.demo.dao;

import com.example.demo.base.dao.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName StudentMapper
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:40
 * @Description TODO
 * @Version 1.0
 **/


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
