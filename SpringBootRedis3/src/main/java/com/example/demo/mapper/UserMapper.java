package com.example.demo.mapper;

import com.example.demo.entity.User;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:22
 * @Description TODO
 * @Version 1.0
 **/
public interface UserMapper {
    void insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(User user);
}
