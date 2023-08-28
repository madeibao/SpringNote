package com.example.demo;

import com.example.demo.service.HelloService;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private HelloService helloService;

    @Test
    public void test() {
        helloService.sayHello();
    }
}
