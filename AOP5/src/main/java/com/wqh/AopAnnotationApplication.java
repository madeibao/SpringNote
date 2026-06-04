package com.wqh;

import com.wqh.service.BankService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ASUS
 */
//@EnableAspectJAutoProxy
//@ComponentScan({"com.wqh"})

public class AopAnnotationApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop-annotation.xml");
        BankService bankService = context.getBean(BankService.class);

        bankService.transfer("wqh","jack",2000);

    }
}
