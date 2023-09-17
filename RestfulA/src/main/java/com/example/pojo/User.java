package com.example.pojo;

import java.util.List;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/9/14/0014 10:59
 * @Description TODO
 * @Version 1.0
 **/
public class User {
    private String userName;
    private int age;
    private List<String> address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

