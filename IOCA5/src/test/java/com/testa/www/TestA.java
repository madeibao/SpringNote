package com.testa.www;

import com.mayuan.www.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/3/0003 10:56
 * @Description TODO
 * @Version 1.0
 **/

public class TestA {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("学生"+student.getName()+"  开着"+student.getCar().getColor()+"的  "+student.getCar().getType());
    }
}
