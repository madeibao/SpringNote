package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Demo
 * @Author：Mayuan
 * @Date 2023/8/15/0015 16:23
 * @Description TODO
 * @Version 1.0
 **/
//加入这个注解，Demo 就会进行持久化了，在这里没有对@Table 进行配置，请自行配置。

@Entity
@Table(name = "demo",schema = "kaifamiao")
public class Demo {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Demo() {
    }

    public Demo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
