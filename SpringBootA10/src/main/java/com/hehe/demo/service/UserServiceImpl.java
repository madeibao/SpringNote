package com.hehe.demo.service;

import com.hehe.demo.mapper.UserMapper;
import com.hehe.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/20/0020 21:39
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class UserServiceImpl  implements UserService {

    @SuppressWarnings("all")
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User get(String userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public int delete(String userId) {
        return userMapper.delete(userId);
    }
}
