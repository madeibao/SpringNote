package com.mayuan.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AppTest
 * @Author：Mayuan
 * @Date 2022/1/23/0023 16:07
 * @Description TODO
 * @Version 1.0
 **/


public class AppTest {

    @Test
    public void test01() {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");

        // 获取Bean的实例时，
        Object beanA  = ioc.getBean("book01");
        System.out.println(beanA);
        ioc.close();

    }

}
