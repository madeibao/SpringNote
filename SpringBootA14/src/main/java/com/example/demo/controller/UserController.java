package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/8/21/0021 10:54
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("info", "user/list");
        return "index";
    }

    @GetMapping("/user")
    public String hehe(Model model) {
        model.addAttribute("user", new User(UUID.randomUUID().toString(), "nijitaimei", "2019998"));
        return "user";
    }

    @GetMapping("/user/list")
    public String userlist(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(UUID.randomUUID().toString(), "yizhiwazi", "20170928"));
        userList.add(new User(UUID.randomUUID().toString(), "kumamon", "123456"));
        userList.add(new User(UUID.randomUUID().toString(), "admin", "admin"));
        model.addAttribute("userList", userList);
        return "userList";
    }

}
