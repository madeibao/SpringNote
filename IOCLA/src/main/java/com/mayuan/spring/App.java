package com.mayuan.spring;

/**
 * @ClassName App
 * @Author：Mayuan
 * @Date 2022/1/23/0023 18:20
 * @Description TODO
 * @Version 1.0
 *
 *  Spring的语言表达式的书写方式。
 *  Spring的SPEL 表达式写法。
 **/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Boss boss = (Boss) ctx.getBean("boss");
        System.out.println(boss);

    }

}
