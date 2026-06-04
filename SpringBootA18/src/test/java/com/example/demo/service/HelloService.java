package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Author：Mayuan
 * @Date 2023/8/23/0023 15:08
 * @Description TODO
 * @Version 1.0
 **/

@Service("helloService")
public class HelloService {

    public String sayHello(){
        return "hellox";
    }
}
