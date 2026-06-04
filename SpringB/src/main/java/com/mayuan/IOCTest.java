package com.mayuan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName IOCTest
 * @Author：Mayuan
 * @Date 2021/12/26/0026 20:37
 * @Description TODO
 * @Version 1.0
 **/

public class IOCTest {
    static ApplicationContext ioc=new ClassPathXmlApplicationContext("IOC.xml");

    public static void main(String[] args) {
        test01();
//        test02();
    }

    /**
     * 实验2：根据bean的类型从IOC容器中获取bean的实例
     * 如果ioc容器中这个类型的bean有多个，那么用第一种方式查找就会报错。
     * */
    public static void test02() {
        //Person bean=ioc.getBean(Person.class);
        //System.out.println(bean);
        Person bean2=ioc.getBean("person02",Person.class);
        System.out.println(bean2);

        Object bean3=ioc.getBean("person03");
        System.out.println(bean3);

        Object bean4=ioc.getBean("person04");
        System.out.println(bean4);

        //还可以这样：
    }

    /**
     * 从容器中拿到这个组件
     */

    public static void test01() {
        //创建对象是容器做的
        Person bean=(Person)ioc.getBean("person01");

        System.out.println(bean);
    }

}
