package com.wqh.service.Impl;

import com.wqh.service.UserService;

public class USerServiceImpl implements UserService  {
    public String login(String userName, String password) {
        System.out.println("login username:"+userName+",password:"+password);
        if(userName == null){
            throw new NullPointerException("username is  null");
        }
        return "OK";
    }

    public String register(String userName, String password) {
        System.out.println("login username:"+userName+",password:"+password);
        return "OK";
    }
}
