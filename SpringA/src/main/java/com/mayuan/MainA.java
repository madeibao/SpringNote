package com.mayuan;

/**
 * @ClassName MainA
 * @Author：Mayuan
 * @Date 2021/12/19/0019 22:35
 * @Description TODO
 * @Version 1.0
 **/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainA {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
        user.add();
    }
}
