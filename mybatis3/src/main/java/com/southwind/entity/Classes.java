package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName classes
 * @Author：Mayuan
 * @Date 2020/12/25/0025 20:05
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {

    private long id;
    private String name;
    private List<Student> students;

}
