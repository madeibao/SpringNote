package com.mayuan.test3;

import com.mayuan.study.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/4/6/0006 22:36
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserService userService  = (UserService) context.getBean("userServiceImpl");

        userService.update();
    }

}
