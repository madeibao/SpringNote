package com.mayuan.test;

import com.mayuan.spring.Person;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Author：Mayuan
 * @Date 2022/1/23/0023 16:43
 * @Description TODO
 * @Version 1.0
 **/
public class TestSpring {

    @Test
    public void testNoProcessorCycle(){
        ConfigurableApplicationContext caContext=new ClassPathXmlApplicationContext("application.xml");
        Person person=(Person) caContext.getBean("persona");
        caContext.close();
    }
}
