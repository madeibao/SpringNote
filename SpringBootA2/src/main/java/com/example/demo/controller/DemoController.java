package com.example.demo.controller;

import com.example.demo.entity.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 15:46
 * @Description TODO
 * @Version 1.0
 **/


@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/getDemo")
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("kaifamiao");
        return demo;
    }
}
