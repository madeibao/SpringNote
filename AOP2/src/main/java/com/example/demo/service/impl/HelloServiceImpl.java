package com.example.demo.service.impl;


import com.example.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author ASUS
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("hello aop");
    }
}
