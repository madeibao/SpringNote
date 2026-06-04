package com.yongli.demo.bean;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:31
 * @Description TODO
 * @Version 1.0
 **/


public class Role implements Serializable {

    private static final long serialVersionUID = -3802292814767103648L;

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
