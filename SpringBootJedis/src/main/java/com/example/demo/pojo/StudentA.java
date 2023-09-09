package com.example.demo.pojo;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/9/9/0009 15:24
 * @Description TODO
 * @Version 1.0
 **/


public class StudentA implements Serializable {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "StudentA{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public StudentA(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public StudentA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

