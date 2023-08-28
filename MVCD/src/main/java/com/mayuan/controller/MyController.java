package com.mayuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/12/0012 14:56
 * @Description TODO
 * @Version 1.0
 **/


@Controller
@RequestMapping(value = "/user")
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView mv = new ModelAndView();

        //可以手动添加数据到request域中
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("show");
        return mv;
    }
}
