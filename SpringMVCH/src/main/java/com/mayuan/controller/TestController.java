package com.mayuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author：Mayuan
 * @Date 2022/3/27/0027 10:48
 * @Description TODO
 * @Version 1.0
 **/


@RestController
public class TestController {
    @GetMapping("/t1")
    public String test() {
        System.out.println("TestController.test");
        return "ok";
    }
}
