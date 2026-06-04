package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/16/0016 20:01
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService{

    /** 注入mapper对象*/
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
