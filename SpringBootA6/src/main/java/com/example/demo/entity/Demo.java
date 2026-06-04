package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

/**
 * @ClassName Demo
 * @Author：Mayuan
 * @Date 2023/8/15/0015 16:44
 * @Description TODO
 * @Version 1.0
 **/


@Entity
@Table(name = "DEMO" ,schema = "ROOT")
public class Demo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public Demo() {
        super();
    }

    public Demo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Demo(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
