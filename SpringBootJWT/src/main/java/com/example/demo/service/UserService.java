package com.example.demo.service;

import com.example.demo.pojo.Users;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:56
 * @Description TODO
 * @Version 1.0
 **/

@Service
public interface UserService {

    Users login(Users users);
}
