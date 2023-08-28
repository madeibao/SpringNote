package com.mayuan.study;

import org.springframework.stereotype.Component;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2022/4/6/0006 22:35
 * @Description TODO
 * @Version 1.0
 **/

@Component
public class UserServiceImpl implements UserService {

    public void insert() {
        System.out.println("增加用户");
    }

    public void delete() {
        System.out.println("删除用户");
    }

    public void update() {
        System.out.println("更新用户");
    }

    public void select() {
        System.out.println("查询用户");
    }
}
