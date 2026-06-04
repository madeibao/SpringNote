package com.mayuan.spring.entity;

/**
 * @ProjectName: JDBCA
 * @Package: com.mayuan.spring.entity
 * @ClassName: Book
 * @Author: mi
 * @Date: 2022/2/20 11:09
 * @Version: 1.0
 */
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
