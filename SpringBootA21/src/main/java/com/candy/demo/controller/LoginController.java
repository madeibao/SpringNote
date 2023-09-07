package com.candy.demo.controller;

import com.candy.demo.bean.UserInfo;
import com.candy.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:39
 * @Description TODO
 * @Version 1.0
 **/


@RestController
//也可以通过使用注解，处理跨域问题
//@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/userlogin")
    public String logined(UserInfo userInfo){
        System.out.println("已接收到前台发送过来的请求"+userInfo);
        boolean ok= loginService.login(userInfo);
        if(ok){
            return "ok";
        }else {
            return "eg";
        }

    }
}
