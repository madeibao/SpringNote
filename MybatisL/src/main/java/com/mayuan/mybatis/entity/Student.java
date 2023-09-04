package com.mayuan.mybatis.entity;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2023/8/31/0031 14:47
 * @Description TODO
 * @Version 1.0
 **/
public class Student {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Student() {

    }

    public Student(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
