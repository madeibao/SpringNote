package com.mayuan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName App
 * @Author：Mayuan
 * @Date 2022/1/18/0018 22:52
 * @Description TODO
 * @Version 1.0
 **/
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Ioc.xml");
        School school = (School) context.getBean("school");
        System.out.print("student name:" + school.getStudents().getName() + "teacher name :" + school.getTeachers().getName());
    }

}
