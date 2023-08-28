package com.mayuan.test;

import com.mayuan.spring.Employer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName EmployerTest
 * @Author：Mayuan
 * @Date 2022/1/23/0023 13:19
 * @Description TODO
 * @Version 1.0
 **/


public class EmployerTest {

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Employer employer = context.getBean("employer", Employer.class);
        System.out.printf(employer.toString());
    }

}
