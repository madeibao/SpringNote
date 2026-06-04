package com.mayuan.controller;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2022/3/20/0020 17:24
 * @Description TODO
 * @Version 1.0
 *
 * 类上没有 @RequestMapping("/mayuan")
 * http://localhost:8081/SpringMVCE/hello
 *
 * 类上有@RequestMapping("/mayuan")
 * http://localhost:8081/SpringMVCE/mayuan/hello
 **/


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/mayuan")
public class HelloController {

    //真实访问地址/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC Annotation!!!!");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}


