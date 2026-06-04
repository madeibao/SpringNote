package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorld
 * @Author：Mayuan
 * @Date 2023/8/15/0015 9:43
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String hello() {
        return "hello SpringBoot World";
    }
}
