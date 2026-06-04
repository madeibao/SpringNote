package com.wjb.service;

import com.wjb.face.service.UserService;

/**
 * @Description
 * @Author jianbo wang
 * @Date:2021/12/2 0002 8:04
 */
public class UserServiceImpl implements UserService {
    @Override
    public void say() {
        System.out.println("这是一个服务类");
    }
}
