package com.mayuan.www;

/**
 * @ClassName MyBook
 * @Author：Mayuan
 * @Date 2023/8/10/0010 15:17
 * @Description TODO
 * @Version 1.0
 **/


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 增高类
 * @author 马远
 */
@Aspect
public class MyBook {
    @Before(value="execution(* com.mayuan.www.Book.*(..))")
    public void before() {
        System.out.println("anno before增强.....");
    }
    @After(value="execution(* com.mayuan.www.Book.*(..))")
    public void after() {
        System.out.println("anno after增强.....");
    }

    @Around(value="execution(* com.mayuan.www.Book.*(..))")
    public void around(ProceedingJoinPoint p) throws Throwable {
        //方法之前
        System.out.println("anno before.....");
        //执行被增强的方法
        p.proceed();
        //方法之后
        System.out.println("anno after......");
    }
}