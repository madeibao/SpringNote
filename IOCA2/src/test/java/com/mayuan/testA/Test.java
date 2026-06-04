package com.mayuan.testA;

import com.mayuan.spring.Obj;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Author：Mayuan
 * @Date 2023/7/30/0030 22:45
 * @Description TODO
 * @Version 1.0
 **/


public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Obj bean = app.getBean(Obj.class);
        System.out.println(bean);
    }

}
