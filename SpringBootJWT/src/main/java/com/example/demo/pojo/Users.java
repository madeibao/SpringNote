package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName Users
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:52
 * @Description TODO
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users implements Serializable {
    private Integer id;
    private String name;
    private String password;
}
