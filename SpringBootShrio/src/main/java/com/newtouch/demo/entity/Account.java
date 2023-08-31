package com.newtouch.demo.entity;

import lombok.Data;

/**
 * @ClassName Account
 * @Author：Mayuan
 * @Date 2023/8/31/0031 10:31
 * @Description TODO
 * @Version 1.0
 **/

@Data
public class Account {
    private Integer id;
    private String username;
    private  String password;
    private  String perms;
    private String role;
}
