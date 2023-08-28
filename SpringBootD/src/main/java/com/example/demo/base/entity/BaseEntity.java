package com.example.demo.base.entity;

import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:37
 * @Description TODO
 * @Version 1.0
 **/
public class BaseEntity {

    protected String id;
    protected String createUser;
    protected String updateUser;
    protected Date createTime;
    protected Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
