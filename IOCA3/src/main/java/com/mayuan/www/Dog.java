package com.mayuan.www;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Dog
 * @Author：Mayuan
 * @Date 2023/8/2/0002 21:52
 * @Description TODO
 * @Version 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private String name;
    private int age;
}

