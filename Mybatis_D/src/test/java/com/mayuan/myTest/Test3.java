package com.mayuan.myTest;

import com.mayuan.entity.Classes;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName Test3
 * @Author：Mayuan
 * @Date 2022/2/26/0026 20:10
 * @Description TODO
 * @Version 1.0
 *
 *
 *
 * 这里是一个 一对一的查询方案
 * 数据库关联案例中中的一对一的查询内容
 **/



public class Test3 {

    @Test
    public void testGetClass() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mayuan.config.classMapper.getClass";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }

    @Test
    public void testGetClass2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mayuan.config.classMapper.getClass2";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(clazz);
        //打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }
}