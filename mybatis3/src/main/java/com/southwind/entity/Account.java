package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Account
 * @Author：Mayuan
 * @Date 2020/12/24/0024 20:14
 * @Description TODO
 * @Version 1.0
 **/


// 构造器，写入各种方法，
// 无参数构造器和有参数的构造器方法。

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private long id;
    private String username;
    private String password;
    private int age;

}
