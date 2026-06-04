package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Account
 * @Author：Mayuan
 * @Date 2021/12/19/0019 16:51
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class Account {
    private long id;
    private String username;
    private String password;
    private int age;

}