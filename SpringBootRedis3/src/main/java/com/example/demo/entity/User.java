package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:21
 * @Description TODO
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private Byte sex;
}
