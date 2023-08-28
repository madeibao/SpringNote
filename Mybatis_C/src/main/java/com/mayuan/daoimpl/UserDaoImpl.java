package com.mayuan.daoimpl;

import com.mayuan.dao.UserDao;
import com.mayuan.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Author：Mayuan
 * @Date 2022/2/25/0025 22:26
 * @Description TODO
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public User findUserById(int id) throws Exception {
        String resource = "mybatisA.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        //参数一：namespace.id
        User user = session.selectOne("user.findUserById",id);
        //--------------
        session.close();
        return user;
    }

    @Override
    public List<User> findAllUsers() throws Exception {
        String resource = "mybatisA.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        List<User> users = session.selectList("user.findUserAll");
        //----------------------
        session.close();
        return users;
    }

    @Override
    public void insertUser(User user) throws Exception {
        String resource = "mybatisA.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.insert("user.insertUser", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    @Override
    public void deleteUserById(int id) throws Exception {
        String resource = "mybatisA.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.delete("user.deleteUserById", id);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }

    @Override
    public void updateUserPassword(User user) throws Exception {
        String resource = "mybatisA.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------------
        session.update("user.updateUserPassword", user);
        session.commit();   //增删改，一定一定要加上commit操作
        //----------------------
        session.close();
    }
}
