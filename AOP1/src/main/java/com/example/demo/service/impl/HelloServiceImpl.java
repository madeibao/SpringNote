package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.stereotype.Service;
/**
 * @ClassName HelloServiceImpl
 * @Author：Mayuan
 * @Date 2022/4/7/0007 22:22
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("hello aop");
    }
}
