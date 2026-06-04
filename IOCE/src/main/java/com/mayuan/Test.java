package com.mayuan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Author：Mayuan
 * @Date 2022/1/22/0022 22:29
 * @Description TODO
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        //1.获取spring核心容器对象,加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        //2.根据id获取Bean对象
        //输出获取实例StudentOne是单例对象
        //一样的对象实例
        System.out.println("单例：");
        System.out.println(ac.getBean("StudentOne"));
        System.out.println(ac.getBean("StudentOne"));
        System.out.println(ac.getBean("StudentOne"));
        //输出获取实例StudentTwo是单例对象


        //不一样的对象实例
        System.out.println("多例：");
        System.out.println(ac.getBean("StudentTwo"));
        System.out.println(ac.getBean("StudentTwo"));
        System.out.println(ac.getBean("StudentTwo"));
    }
}
