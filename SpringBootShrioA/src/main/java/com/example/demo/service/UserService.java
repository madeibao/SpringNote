package com.example.demo.service;

import com.example.demo.po.User;

/**
 * @ClassName UserService
 * @Author：Mayuan
 * @Date 2023/9/16/0016 20:00
 * @Description TODO
 * @Version 1.0
 **/

public interface UserService {
    User findByName(String username);
    User findById(Integer id);
}
