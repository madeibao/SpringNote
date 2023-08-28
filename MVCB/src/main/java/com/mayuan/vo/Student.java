package com.mayuan.vo;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2023/8/12/0012 10:42
 * @Description TODO
 * @Version 1.0
 **/
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student的无参构造方法！");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName：" + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge：" + age);
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
