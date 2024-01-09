package com.mayuan.demo;

import com.mayuan.mybatis.entity.StudentA;
import com.mayuan.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/3/2/0002 21:53
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {
    protected SqlSession session = null;

    @Before
    public void init() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        this.session = sf.openSession();
    }

    @After
    public void close() {
        session.commit();
        session.close();
    }


    @Test
    public void aa() {
        StudentMapper sdao = this.session.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "诸葛亮");
        map.put("age", 23);
        map.clear();
        List<StudentA> list = sdao.query(map);
        for (StudentA s : list) {
            System.out.println(s.getName());
        }
    }

    // 更新语句的写法
    @Test
    public void bb() {
        StudentMapper sdao = this.session.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", 99);
        map.put("id", 1);

        sdao.update(map);
    }

}