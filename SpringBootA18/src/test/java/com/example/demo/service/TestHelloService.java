package com.example.demo.service;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TestHelloService
 * @Author：Mayuan
 * @Date 2023/8/23/0023 15:09
 * @Description TODO
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DemoApplication.class}) // 指定我们SpringBoot工程的Application启动类
public class TestHelloService {

    //  自动装配业务逻辑层
    @Autowired
    private HelloService helloService;


    @Test
    public void testSayHello() {
        helloService.sayHello();
    }
}
