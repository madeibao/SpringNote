package com.mayuan.study;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * @ClassName LogAdvice
 * @Author：Mayuan
 * @Date 2022/4/6/0006 22:35
 * @Description TODO
 * @Version 1.0
 **/


/** 两个注解定义一个切面类 */
@Component
@Aspect
public class LogAdvice {
    @Before("execution(* com.mayuan.study.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }


    @After("execution(* com.mayuan.study.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }
}
