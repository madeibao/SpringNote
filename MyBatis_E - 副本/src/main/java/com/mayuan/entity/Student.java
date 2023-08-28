package com.mayuan.entity;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2022/2/27/0027 10:37
 * @Description TODO
 * @Version 1.0
 **/


public class Student {

    //定义属性，和student表中的字段对应
    private int id;            //id===>s_id
    private String name;    //name===>s_name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}