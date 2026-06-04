package com.southwind.test;

import com.southwind.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Test
 * @Author：Mayuan
 * @Date 2020/12/24/0024 20:30
 * @Description TODO
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.southwind.mapper.AccoutMapper.save";
        Account account = new Account(1L, "张三", "123123", 22);
        sqlSession.insert(statement, account);

        // 提交事务
        sqlSession.commit();
    }
}
