package com.proxy.www.impl;

import com.proxy.www.UserService;

/**
 * 接口实现类
 *
 * @ClassName UserServiceImpl
 * @Author Mayuan
 * @Date 2026/9/9/星期三 20:27
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("【目标方法】新增用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("【目标方法】删除用户");
    }
}
