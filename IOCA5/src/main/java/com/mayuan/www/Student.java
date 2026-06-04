package com.mayuan.www;

/**
 * 学生类
 * @author ASUS
 */

public class Student {
    private String name;
    private Integer age;
    private Car car;

    /**
     * 无参构造
     */
    public Student() {
    }

    /**
     * 带参数构造
     * @param name
     * @param age
     * @param car
     */
    public Student(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
