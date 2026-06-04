package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2022/4/4/0004 15:45
 * @Description TODO
 * @Version 1.0
 **/


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String  hello(){
        return "hello SpringBoot frameWork";
    }
    //REST API
}
