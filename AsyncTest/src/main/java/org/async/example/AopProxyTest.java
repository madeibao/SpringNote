package org.async.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName AopProxyTest
 * @Author：Mayuan
 * @Date 2024/7/6/星期六 11:24
 * @Description TODO
 * @Version 1.0
 **/
@ComponentScan
@EnableAsync
public class AopProxyTest {
    public static void main(String[] args) {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopProxyTest.class);
        Person bean = context.getBean(Person.class);
        bean.show("abc");
    }
}
