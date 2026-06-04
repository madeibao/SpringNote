package com.valid.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName StudentController
 * @Author：Mayuan
 * @Date 2024/9/21/星期六 17:11
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("Student")
public class StudentController {

    @ResponseBody
    @RequestMapping("/test1")
    public Integer test1(@RequestParam int a) {
        System.out.println(a);
        return a;
    }
}