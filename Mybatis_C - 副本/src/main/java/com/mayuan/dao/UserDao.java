package com.mayuan.dao;

/**
 * @ClassName UserDao
 * @Author：Mayuan
 * @Date 2022/2/25/0025 22:18
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.entity.User;

import java.util.List;


// 接口
public interface UserDao {
    public User findUserById(int id) throws Exception ;
    public List<User> findAllUsers() throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserById(int id) throws Exception;
    public void updateUserPassword(User user) throws Exception;
}