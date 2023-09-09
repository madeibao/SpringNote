package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentService
 * @Author：Mayuan
 * @Date 2023/9/8/0008 11:27
 * @Description TODO
 * @Version 1.0
 **/


@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Student> findAll() {
        String key = "student";
        ListOperations<String,Student> operations = redisTemplate.opsForList();
        //缓存存在
        if(redisTemplate.hasKey(key)) {
            System.out.println("findAll>>>>>来自redis");
            List<Student> range = operations.range(key, 0, -1);
            System.out.println(range.get(0).getId());
            return range;
        }
        else {
            //得到学生集合
            List<Student> list = studentMapper.findAll();
            operations.leftPushAll(key,list);
            System.out.println("findAll>>>>>来自数据库");
            return list;
        }

    }
}
