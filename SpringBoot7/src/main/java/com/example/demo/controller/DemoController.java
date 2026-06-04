package com.example.demo.controller;

import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName DemoController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 17:43
 * @Description TODO
 * @Version 1.0
 **/

@Controller
@RequestMapping("/demo2")
public class DemoController {

    @Autowired
    private DemoService2 demoService2;

    @ResponseBody
    @RequestMapping("/show")
    public Demo showDemo(@RequestParam(name = "no", defaultValue = "1", required = true)Integer id){
        return demoService2.getById(id);
    }
}

//  http://localhost:8080/demo2/show