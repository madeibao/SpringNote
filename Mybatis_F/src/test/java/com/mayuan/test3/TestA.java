package com.mayuan.test3;

import com.mayuan.spring.beans.User;
import com.mayuan.spring.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/2/28/0028 22:08
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟条件User
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zs");
        condition.setPassword("123");
        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        List<User> byIds = mapper.findByIds(ids);
        System.out.println(byIds);
    }
}
