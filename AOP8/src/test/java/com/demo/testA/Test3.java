package com.demo.testA;

/**
 * @ClassName Test3
 * @Author：Mayuan
 * @Date 2022/4/21/0021 22:37
 * @Description TODO
 * @Version 1.0
 **/

import com.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test3 {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("*/applicationContext.xml");
    }

    @Test
    public void test() {
        try {
            UserService userService = (UserService) ac.getBean("userService");
            userService.insertUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

