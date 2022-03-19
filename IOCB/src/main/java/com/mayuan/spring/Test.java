package com.mayuan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Author：Mayuan
 * @Date 2022/1/19/0019 22:40
 * @Description TODO
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        //1.创建spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        //2.从容器中获取Bean实例
        Student student = (Student) ctx.getBean("student");
        System.out.println(student.toString());
    }
}
