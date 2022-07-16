package com.sp.diy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 注解
 */
@Aspect//标注为切面
public class AnnotationPointCut {
    @Before("execution(* com.sp.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("注解执行前");
    }
    @After("execution(* com.sp.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("注解执行后");
    }
    @Around("execution(* com.sp.service.UserServiceImpl.*(..))")
    public void around(){

    }
}
