package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Users;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:56
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    /** 注入Mapper*/

    @Resource
    UserMapper userMapper;

    @Override
    public Users login(Users users) {
        return userMapper.login(users);
    }
}
