package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloServiceAop
 * @Author：Mayuan
 * @Date 2022/4/7/0007 22:21
 * @Description TODO
 * @Version 1.0
 **/

@Aspect
@Component
public class HelloServiceAop {
    /**
     * 匹配com.learn.service.impl包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.example.demo.service..impl..*.*(..))")
    public void executeService(){

    }

    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        System.out.println(obj);
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        System.out.println(signature.getDeclaringType());
    }
}
