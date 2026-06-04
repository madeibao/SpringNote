package com.example.demo.controller;

import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName DemoController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 16:46
 * @Description TODO
 * @Version 1.0
 **/


@Controller
@RequestMapping("/demo2")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/save")
    public String save(){
        demoService.save(new Demo("angle"));
        demoService.save(new Demo("triangle"));

        return "ok the data was saved";
    }

}
