package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/9/14/0014 11:00
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class UserController {
    /**2.2设置当前操作的访问路径,设置rest的请求风格*/


    /**2.3设置当前操作的返回类型*/
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        System.out.println("user save ----"+user);
        return "{'module':'user save'}";
    }

    /**设置请求参数在url中的位置*/
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        System.out.println("user delete ----"+id);
        return "{'module':'user delete'}";
    }

    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user) {
        System.out.println("user update ----"+user);
        return "{'module':'user update'}";
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        System.out.println("user getById ----"+id);
        return "{'module':'user getById'}";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        System.out.println("user getAll ----");
        return "{'module':'user getAll'}";
    }
}
