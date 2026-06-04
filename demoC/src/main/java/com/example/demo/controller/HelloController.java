package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2022/4/4/0004 20:25
 * @Description TODO
 * @Version 1.0
 **/


@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;
    @RequestMapping("/hello")
    public  String sayHello() {
        return "Hello  "+ name;
    }
}
