package com.aop.aspect.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 田治功
 * @create 2021-02-26 12:16
 * @Description 增强类
 */
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    /**
     相同切入点抽取
     */
    @Pointcut(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void point() {

    }

    //@Before注解表示前置通知
    @Before(value = "point()")
    public void before() {
        System.out.println("前置通知：before方法");
    }

    @After(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void after() {
        System.out.println("最终通知：after方法");
    }

    @AfterReturning(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void afterReturning() {
        System.out.println("后置通知：afterReturning方法");
    }

    @AfterThrowing(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void afterThrowing() {
        System.out.println("异常通知：afterThrowing方法");
    }

    @Around(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前：around方法");
        proceedingJoinPoint.proceed();//执行被增强的方法
        System.out.println("环绕之后：around方法");
    }

}

