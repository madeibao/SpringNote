package com.mayuan.www;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2023/8/10/0010 16:46
 * @Description TODO
 * @Version 1.0
 **/

/**
 * Created by Yifan Jia on 2018/6/12.
 * @Author mayuan
 */
public class Person {

    private String name;

    private Integer age;

    public Person() { }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
