package com.spring.test;

import com.mayuan.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Author：Mayuan
 * @Date 2022/1/23/0023 22:56
 * @Description TODO
 * @Version 1.0
 *
 * 自动赋值
 **/
public class TestSpring {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
    @Test
    public void test02(){

        BookServlet bookServlet = ioc.getBean(BookServlet.class);
        bookServlet.doGet();
    }

}
