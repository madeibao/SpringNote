package com.example.aop.service;

import com.example.aop.annotation.NeedLog;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @ClassName UserService
 * @Author Mayuan
 * @Date 2026/6/4/星期四 11:06
 * @Version 1.0
 **/
@Service
public class UserService {
    // 使用自定义注解，会被环绕通知增强
    @NeedLog("用户查询操作")
    public String findUserById(Long id) {
        System.out.println("【业务逻辑】正在查询用户, id: " + id);
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("用户ID必须大于0");
        }
        return "User{id=" + id + ", name='张三'}";
    }

    // 没有注解，只会被 Before/After/AfterReturning 通知增强
    public void createUser(String username) {
        System.out.println("【业务逻辑】正在创建用户: " + username);
    }

    // 模拟异常场景
    public void deleteUser(Long id) {
        System.out.println("【业务逻辑】正在删除用户, id: " + id);
        if (id == null) {
            throw new RuntimeException("用户ID不能为空");
        }
    }
}