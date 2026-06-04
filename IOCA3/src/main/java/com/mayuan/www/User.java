package com.mayuan.www;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/8/2/0002 21:51
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private Dog dog;
}