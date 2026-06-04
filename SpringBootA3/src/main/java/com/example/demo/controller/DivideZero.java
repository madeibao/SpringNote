package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DivideZero
 * @Author：Mayuan
 * @Date 2023/8/15/0015 15:59
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class DivideZero {
    @RequestMapping("/zeroException")
    public int zeroException() {
        return 100/0;
    }
}
