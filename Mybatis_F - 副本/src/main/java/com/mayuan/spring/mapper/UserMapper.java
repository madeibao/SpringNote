package com.mayuan.spring.mapper;

import com.mayuan.spring.beans.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2022/2/28/0028 22:04
 * @Description TODO
 * @Version 1.0
 **/

public interface UserMapper {

    public List<User> findByCondition(User user);
    public List<User> findByIds(List<Integer> ids);
}

