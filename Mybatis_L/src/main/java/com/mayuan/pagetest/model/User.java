package com.mayuan.pagetest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/8/18/0018 9:44
 * @Description TODO
 * @Version 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String test_name;
    private int age;
    private String user_addr;
}
