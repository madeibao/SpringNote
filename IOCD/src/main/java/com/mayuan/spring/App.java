package com.mayuan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName App
 * @Author：Mayuan
 * @Date 2022/1/21/0021 22:33
 * @Description TODO
 * @Version 1.0
 **/
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(context.getBean("a", StudentA.class));
        System.out.println(context.getBean("b", StudentB.class));
    }

}
