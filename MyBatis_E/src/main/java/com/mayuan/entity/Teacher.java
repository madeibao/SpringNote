package com.mayuan.entity;

/**
 * @ClassName Teacher
 * @Author：Mayuan
 * @Date 2022/2/27/0027 10:40
 * @Description TODO
 * @Version 1.0
 **/


public class Teacher {

    /**定义实体类的属性，与teacher表中的字段对应
     */

    //id===>t_id
    private int id;
    //name===>t_name
    private String name;

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
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
}