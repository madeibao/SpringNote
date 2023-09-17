package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/9/16/0016 20:06
 * @Description TODO
 * @Version 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello world");
        return "hello world";
    }

    /**
     * 测试thymeleaf是否可用
     */
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","黑马程序员");
        return "test";
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录的逻辑请求
     * @return
     */
    @RequestMapping("/login.action")
    public String loginAction(String name,String password,Model model) {
        /**
         * 使用shiro编写认证操作
         */
//        1.获取Subject
        Subject subject = SecurityUtils.getSubject();
//        2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//        执行登录方法
        try {
            // 登录成功--login执行的是realm中的认证操作
            subject.login(token);
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
//            e.printStackTrace();
            model.addAttribute("msg", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("/unauth")
    public String unauth(){
        return "unauth";
    }

}
