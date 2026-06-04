package com.example.demo.service;

import com.example.demo.base.service.BaseService;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:43
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class UserService extends BaseService<User, UserMapper> {

}
