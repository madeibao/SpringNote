package com.mayuan.jdbc.entity;

/**
 * @ClassName Book
 * @Author：Mayuan
 * @Date 2022/2/26/0026 22:45
 * @Description TODO
 * @Version 1.0
 **/
public class Book {
    private int userId;
    private String username;
    private String userStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
