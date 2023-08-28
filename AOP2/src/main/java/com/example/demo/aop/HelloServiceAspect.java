package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author ASUS
 */
@Aspect
public class HelloServiceAspect {
    /**
     *     匹配com.learn.service.impl包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.example.demo.service.impl..*.*(..))")
    public void executeService(){ }
}
