package com.mayuan.test3;

import com.mayuan.spring.dao.UserDao;
import com.mayuan.spring.pojo.User;
import com.mayuan.spring.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/3/3/0003 21:57
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    //获取sqlSession
    SqlSession sqlSession = MyBatisUtil.createSqlsession();
    //获取接口
    UserDao userDao = sqlSession.getMapper(UserDao.class);

    @Test
    public void getUserByCon() {
        List<User> users = userDao.getUserByCon("e", "5");
        for (User user : users) {
            System.out.println(user);
        }
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void getUserByCon1() {
        List<User> users = userDao.getUserByCon1("e", "");
        for (User user : users) {
            System.out.println(user);
        }
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("BIG SHOW");
        user.setPassword("bigshow");

        Integer count = userDao.updateUser(user);
        if (count>0){
            System.out.println("更新成功！");
        }else {
            System.out.println("更新失败！");
        }

        // 关闭资源
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void getUserByCondition() {
        List<User> users = userDao.getUserByCondition(3, "", "");
        for (User user : users) {
            System.out.println(user);
        }
        MyBatisUtil.close(sqlSession);
    }


    @Test
    public void getUser() {
        List<String> passwordList = new ArrayList<>();
        passwordList.add("5");
        passwordList.add("6");
        List<User> users = userDao.getUser(passwordList);
        for (User user : users) {
            System.out.println(user);
        }
        MyBatisUtil.close(sqlSession);
    }
}