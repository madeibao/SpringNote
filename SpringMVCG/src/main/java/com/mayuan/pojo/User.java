package com.mayuan.pojo;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2022/3/23/0023 21:54
 * @Description TODO
 * @Version 1.0
 **/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String sex;
}

