package com.mayuan.mybatis.entity;

/**
 * @ClassName StudentA
 * @Author：Mayuan
 * @Date 2022/3/2/0002 21:47
 * @Description TODO
 * @Version 1.0
 **/
public class StudentA {
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
