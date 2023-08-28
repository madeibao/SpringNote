package com.mayuan.test3;

import com.mayuan.spring.entity.Classes;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Assert;

/**
 * @ClassName Test3
 * @Author：Mayuan
 * @Date 2022/3/5/0005 16:31
 * @Description TODO
 * @Version 1.0
 *
 *
 *
 * 这里的测试的是Mybatis的缓存的学习
 * Mybatis默认开启的是一级的缓存
 *
 **/
public class Test3 {

    @Test
    public void testGetClass() {


//        /** 第一个session */
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//
//        String statement = "com.mayuan.config.classMapper.getClass";//映射sql的标识字符串
//        //执行查询操作，将查询结果自动封装成Classes对象返回
//        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
//        //使用SqlSession执行完SQL之后需要关闭SqlSession
//        sqlSession.close();
//        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]

        SqlSession sqlSession = null;
        try {
            /** 第一个session */
            sqlSession = MyBatisUtil.getSqlSession();

            String statement = "com.mayuan.spring.config.classMapper.getClass";//映射sql的标识字符串
            //执行查询操作，将查询结果自动封装成Classes对象返回
            Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            System.out.println(clazz);

            // 如果清理了缓存，那么缓存就会失效
            // sqlSession.clearCache();

            System.out.println("——————————————————————————开启第二次查询-----------------------------");
            Classes clazz2 = sqlSession.selectOne(statement,1);
            Assert.assertEquals(clazz,clazz2);

            System.out.println(clazz2);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testGetClass2() {

        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            /** 第一个session */
            sqlSession = MyBatisUtil.getSqlSession();

            String statement = "com.mayuan.spring.config.classMapper.getClass";//映射sql的标识字符串
            //执行查询操作，将查询结果自动封装成Classes对象返回
            Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            System.out.println(clazz);


            System.out.println("——————————————————————————开启第二次查询-----------------------------");
            sqlSession2 = MyBatisUtil.getSqlSession();

            String statement2 = "com.mayuan.spring.config.classMapper.getClass";//映射sql的标识字符串
            Classes clazz2 = sqlSession2.selectOne(statement2,1);
            System.out.println(clazz2);

            // 这里是一个判断语句，可以直接的进行注释掉
            //  Assert.assertEquals(clazz,clazz2);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
