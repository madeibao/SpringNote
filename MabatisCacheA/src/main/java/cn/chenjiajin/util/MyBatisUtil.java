package cn.chenjiajin.util;

/**
 * @ClassName MyBatisUtil
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:29
 * @Description TODO
 * @Version 1.0
 **/

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    static SqlSessionFactory factory = null;
    static {//该代码只需要执行一次，不需要重复获取连接池对象，
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession() {
        return factory.openSession(); //只需要返回连接对象就行，不用返回连接池对象
    }
}
