package com.mayuan.test3;

import com.mayuan.mybatis.entity.StudentA;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/3/6/0006 20:23
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {


    @Test
    public StudentA findUserById(int id) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession session = sqlSessionFactory.openSession();

        StudentA user = session.selectOne("findUserById",id);

        session.commit();
//        session.close();

        SqlSession session1 = sqlSessionFactory.openSession();//二级缓存测试

        StudentA user2 = session1.selectOne("findUserById",id);

        session.commit();
        session.close();

        return user2;

    }

    public static void main(String[] args) {

        try {
            new TestA().findUserById(1);
            new TestA().findUserById(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

