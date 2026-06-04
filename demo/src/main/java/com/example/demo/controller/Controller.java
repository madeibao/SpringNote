package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Controller
 * @Author：Mayuan
 * @Date 2020/12/25/0025 22:41
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class Controller {

    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }
}
