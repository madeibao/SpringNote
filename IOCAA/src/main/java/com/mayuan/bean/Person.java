package com.mayuan.bean;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2023/9/17/0017 15:31
 * @Description TODO
 * @Version 1.0
 **/

public class Person {

    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
