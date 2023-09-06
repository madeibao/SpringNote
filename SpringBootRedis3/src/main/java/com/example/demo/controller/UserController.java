package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserVo;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @ClassName UserController
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:27
 * @Description TODO
 * @Version 1.0
 **/


@Api(description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("数据库初始化100条数据")
    @RequestMapping(value="/init",method = RequestMethod.GET)
    public void init(){
        for (int i = 0; i < 100; i++) {
            Random random=new Random();
            User user=new User();
            String temp="un"+i;
            user.setName(temp);
            user.setPassword(temp);
            int n=random.nextInt(2);
            user.setSex((byte) n);
            userService.createUser(user);
        }
    }

    @ApiOperation("单个用户查询，按userid查询用户信息")
    @RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
    public UserVo findById(@PathVariable int id){
        User user=this.userService.findUserById(id);
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }

    @ApiOperation("修改某条数据")
    @PostMapping(value = "updateUser")
    public void updateUser(@RequestBody UserVo obj){
        User user=new User();
        BeanUtils.copyProperties(obj,user);
        System.out.println(user.toString());
        userService.updateUser(user);
    }
}
