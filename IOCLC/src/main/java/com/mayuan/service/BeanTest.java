package com.mayuan.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanTest
 * @Author：Mayuan
 * @Date 2022/1/24/0024 22:25
 * @Description TODO
 * @Version 1.0
 **/


public class BeanTest {
    public static void main(String[] args) {
        // 创建Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        // 注册关闭钩子
        ctx.registerShutdownHook();
        Person person = ctx.getBean("chinese" , Person.class);
        person.useAxe();
    }
}
