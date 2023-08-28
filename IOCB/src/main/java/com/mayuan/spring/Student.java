package com.mayuan.spring;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Student
 * @Author：Mayuan
 * @Date 2022/1/19/0019 22:37
 * @Description TODO
 * @Version 1.0
 **/

public class Student {

    private String name;
    private int age;
    private double score;
    private Map<String,Car> cars;
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
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public Map<String, Car> getCars() {
        return cars;
    }
    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", score=" + score + ", cars=" + cars + "]";
    }


}