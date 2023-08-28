package com.example.demo.bean;

/**
 * @ClassName Dog
 * @Author：Mayuan
 * @Date 2022/4/4/0004 20:22
 * @Description TODO
 * @Version 1.0
 **/
public class Dog {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
