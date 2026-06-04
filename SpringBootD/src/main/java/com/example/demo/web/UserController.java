package com.example.demo.web;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:45
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String list(ModelMap map){
        map.put("userList",userService.findList());
        return "/user/list";
    }

    @GetMapping("add")
    public String add(){
        return "/user/add";
    }


    @PostMapping("add")
    public String add(User user){
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap map){
        map.put("user",userService.findById(id));
        return "/user/edit";
    }


    @PostMapping("edit")
    public String edit(User user){
        userService.update(user);
        return "redirect:/user";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/user";
    }
}
