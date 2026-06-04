package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:54
 * @Description TODO
 * @Version 1.0
 **/

/**
 * 登录Mapper
 */
@Mapper
public interface UserMapper {
    Users login(Users users);
}
