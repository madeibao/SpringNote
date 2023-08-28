package com.mayuan.testA;

import com.myuan.www.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestB
 * @Author：Mayuan
 * @Date 2023/8/3/0003 9:47
 * @Description TODO
 * @Version 1.0
 **/
public class TestB {

    public static void main(String[] args) {
        //1.获取spring核心容器对象,加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        //2.根据id获取Bean对象
        //输出获取实例StudentOne是单例对象
        //一样的对象实例
        System.out.println("单例：");
        System.out.println(ac.getBean("StudentOne"));
        System.out.println(ac.getBean("StudentOne"));
        System.out.println(ac.getBean("StudentOne"));
        //输出获取实例StudentTwo是单例对象

        System.out.println("-------------------------------------------");
        Student st =(Student)ac.getBean("StudentOne");
        Student st2 = (Student)ac.getBean("StudentOne");
        System.out.println(st.equals(st2));


        System.out.println("-------------------------------------------");

        //不一样的对象实例
        System.out.println("多例：");
        System.out.println(ac.getBean("TeacherTwo"));
        System.out.println(ac.getBean("TeacherTwo"));
        System.out.println(ac.getBean("TeacherTwo"));
    }
}
