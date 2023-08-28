package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 15:36
 * @Description TODO
 * @Version 1.0
 **/


@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello world!";
    }

}
