package com.aop.aspect.test;

import com.aop.aspect.annotation.User;
import com.aop.aspect.xml.Book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 田治功
 * @create 2021-02-26 14:46
 * @Description
 */
public class TestAop {

    public void testAnnotation() {
        //1.加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectA.xml");
        //2.获取User的bean对象
        User user = context.getBean("user", User.class);
        //3.User的bean对象调用方法
        user.add();//输出：前置通知：before方法|add方法
    }

    public void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectX.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
