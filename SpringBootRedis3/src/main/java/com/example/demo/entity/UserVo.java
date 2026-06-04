package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserVo
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:22
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private Integer id;
    private String name;
    private String password;
}
