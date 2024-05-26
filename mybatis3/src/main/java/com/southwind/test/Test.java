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
        //加载MyBatis配置⽂文件
//        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        String statement = "com.southwind.mapper.AccountMapper.save";
        Account account = new Account(1L,"小马","111",22);
        Account account2 = new Account(2L,"小鲁","222",23);

        sqlSession.insert(statement,account);
        sqlSession.insert(statement,account2);
        sqlSession.commit();
        sqlSession.close();

    }
}
