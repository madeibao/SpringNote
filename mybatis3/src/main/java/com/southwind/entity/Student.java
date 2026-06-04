package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2020/12/25/0025 17:02
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class Student {

    private long id;
    private String name;
    private String classes;

}
