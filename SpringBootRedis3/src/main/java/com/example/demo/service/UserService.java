package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @ClassName UserService
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:23
 * @Description TODO
 * @Version 1.0
 **/
public interface UserService {
    void createUser(User user);

    User findUserById(int id);

    void updateUser(User user);
}
