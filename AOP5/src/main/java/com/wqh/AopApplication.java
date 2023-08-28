package com.wqh;

import com.wqh.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ASUS
 */
public class AopApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        //        userService.login("wqh","123");
        System.out.println("************************");
        userService.login("wqh","1234");
        context.close();
    }
}
