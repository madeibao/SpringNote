package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @ClassName LogAop
 * @Author：Mayuan
 * @Date 2022/4/21/0021 22:34
 * @Description TODO
 * @Version 1.0
 **/

@Component
@Aspect
public class LogAop {

    @Pointcut("execution(* com.demo.service.UserService.insertUser(..))")
    public void ponitCut() {

    }

    @Before("ponitCut()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice");
    }

    @After("ponitCut()")
    public void afterAdvice() {
        System.out.println("afterAdvice");
    }

    //环绕通知。注意要有ProceedingJoinPoint参数传入
    @Around("ponitCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("注解类型环绕通知..环绕前");
        pjp.proceed();//执行方法
        System.out.println("注解类型环绕通知..环绕后");
    }
}
