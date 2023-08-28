package com.mayuan.pagetest.service.impl;

import com.mayuan.pagetest.mapper.UserMapper;
import com.mayuan.pagetest.model.User;
import com.mayuan.pagetest.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/18/0018 10:01
 * @Description TODO
 * @Version 1.0
 **/

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    UserMapper userMapper;
    @Override
    public List<User> pagerFind(Map map) {
        return userMapper.pagerFind(map);
    }
    @Override
    public void insert(User user){
        userMapper.insert(user);
        System.out.println("添加成功");
    }
    @Override
    public void delete(int id){
        userMapper.delete(id);
        System.out.println("删除成功");
    }
}