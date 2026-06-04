package com.hehe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2023/8/21/0021 9:54
 * @Description TODO
 * @Version 1.0
 **/

@Controller
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
