package com.myuan.www;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2023/8/3/0003 9:43
 * @Description TODO
 * @Version 1.0
 **/
public class Student {

    String name;
    int age;
    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
