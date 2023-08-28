package com.mayuan.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName IOCTest
 * @Author：Mayuan
 * @Date 2022/1/23/0023 20:38
 * @Description TODO
 * @Version 1.0
 **/
public class IOCTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");

    @Test
    public void test() {
        Object bean = ioc.getBean("bookDao");
        Object bean1 = ioc.getBean("bookDao");
        System.out.println(bean == bean1);
    }
}
