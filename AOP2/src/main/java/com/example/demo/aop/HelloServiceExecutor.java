package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ASUS
 */
@Aspect
@Component
public class HelloServiceExecutor {

    @Before("com.example.demo.aop.HelloServiceAspect.executeService()")
    public void doBeforeAdvice(){
        System.out.println("我是前置通知!!!");
    }
}
