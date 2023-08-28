package com.mayuan.spring.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyBatisUtil
 * @Author：Mayuan
 * @Date 2022/3/3/0003 21:53
 * @Description TODO
 * @Version 1.0
 **/
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建SqlSession
    public static SqlSession createSqlsession() {
        //创建SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    //释放资源
    public static void close(SqlSession sqlSession) {
        if (null != sqlSession) {
            sqlSession.close();
        }
    }
}
