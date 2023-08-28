package com.mayuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Author：Mayuan
 * @Date 2022/3/27/0027 10:45
 * @Description TODO
 * @Version 1.0
 **/


@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/goLogin")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {

        //把用户的信息存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("password",password);
        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession sessionl) {
        sessionl.removeAttribute("userLoginInfo");
        return "login";
    }
}


