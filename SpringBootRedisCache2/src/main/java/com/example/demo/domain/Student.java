package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2023/9/8/0008 11:26
 * @Description TODO
 * @Version 1.0
 **/

@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private Integer beforeage;

    private static final long serialVersionUID = 1L;
}