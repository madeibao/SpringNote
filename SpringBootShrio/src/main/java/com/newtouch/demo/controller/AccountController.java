package com.newtouch.demo.controller;

import com.newtouch.demo.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AccountController
 * @Author：Mayuan
 * @Date 2023/8/31/0031 10:37
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class AccountController {

    @GetMapping(value = "/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            Account account = (Account) subject.getPrincipal();
            subject.getSession().setAttribute("account",account);
            return "index";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("msg","用户名不存在!");
            return "login";
        }catch (IncorrectCredentialsException e){
            e. printStackTrace();
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @GetMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未授权,无法访问";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
