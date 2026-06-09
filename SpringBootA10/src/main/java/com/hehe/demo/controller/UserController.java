package com.hehe.demo.controller;

import com.hehe.demo.pojo.R;
import com.hehe.demo.pojo.User;
import com.hehe.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/8/20/0020 21:37
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user/*")
public class UserController {

    UserService userService;

    //
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public R<List<User>> list() {
        try {
            return R.isOk().data(userService.list());
        } catch (Exception e) {
            return R.isFail(e);
        }
    }

    @GetMapping("list/{username}")
    public R<List<User>> listbyname(@PathVariable("username")  String username) {
        try {
            return R.isOk().data(userService.findByUsername(username));
        } catch (Exception e) {
            return R.isFail(e);
        }
    }

    @GetMapping("get/{userId}")
    public R<User> get(@PathVariable("userId") String userId) {
        try {
            return R.isOk().data(userService.get(userId));
        } catch (Exception e) {
            return R.isFail(e);
        }
    }

    @GetMapping("del/{userId}")
    public R<Integer> delete(@PathVariable("userId") String userId) {
        try {
            return R.isOk().data(userService.delete(userId));
        } catch (Exception e) {
            return R.isFail(e);
        }
    }

}
