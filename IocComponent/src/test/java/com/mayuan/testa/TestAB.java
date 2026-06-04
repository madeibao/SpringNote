package com.mayuan.testa;

import com.mayuan.www.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestAB
 * @Author：Mayuan
 * @Date 2023/8/1/0001 21:46
 * @Description TODO
 * @Version 1.0
 **/
public class TestAB {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        Student student= (Student)ctx.getBean("myStudent");
        System.out.println(student);
    }
}
