package com.mayuan.mybatisC;

/**
 * @ClassName A
 * @Author：Mayuan
 * @Date 2022/2/25/0025 22:29
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.dao.UserDao;
import com.mayuan.daoimpl.UserDaoImpl;
import com.mayuan.entity.User;
import org.junit.Test;

import java.util.List;


public class A {

    // 根据id来查找
    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    // 查找所有的内容
    @Test
    public void testFindAllUser() throws Exception{
        UserDao userDao = new UserDaoImpl();
        List<User> findAllUsers = userDao.findAllUsers();
        for (User user2 : findAllUsers) {
            System.out.println(user2);
        }
    }

    // 插入内容
    @Test
    public void testInsertUser() throws Exception{
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("王二");
        user.setPassword("abcd");
        user.setAge(13);
        userDao.insertUser(user);
    }


    @Test
    public void testDeleteUserById() throws Exception{
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUserById(3);
    }


    // 更新内容
    @Test
    public void testUpdateUserPassword() throws Exception{
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setId(1);
        user.setPassword("newpassword");
        userDao.updateUserPassword(user);
    }
}