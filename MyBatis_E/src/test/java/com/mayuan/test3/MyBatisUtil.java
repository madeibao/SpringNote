package com.mayuan.test3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ClassName MyBatisUtil
 * @Author：Mayuan
 * @Date 2022/2/27/0027 10:45
 * @Description TODO
 * @Version 1.0
 **/
public class MyBatisUtil {
    static SqlSessionFactory factory = null;
    static {

        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config.xml"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }
}
