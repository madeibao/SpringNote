package com.hehe.demo.service;

import com.hehe.demo.pojo.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Author：Mayuan
 * @Date 2023/8/20/0020 21:38
 * @Description TODO
 * @Version 1.0
 **/
public interface UserService {

    List<User> list();

    List<User> findByUsername(String username);

    User get(String userId);

    int delete(String userId);

}
