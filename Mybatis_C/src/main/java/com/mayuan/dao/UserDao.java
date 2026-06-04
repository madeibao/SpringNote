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

/**
 * 接口
 * @author mayuan1
 */

public interface UserDao {

    User findUserById(int id) throws Exception;
    List<User> findAllUsers() throws Exception;
    void insertUser(User user) throws Exception;
    void deleteUserById(int id) throws Exception;
    void updateUserPassword(User user) throws Exception;
}