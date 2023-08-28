package com.mayuan.testA;

import com.mayuan.www.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/10/0010 15:20
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAOPAnno.xml");
        Book b = (Book) context.getBean("book");
        b.add();
    }
}
