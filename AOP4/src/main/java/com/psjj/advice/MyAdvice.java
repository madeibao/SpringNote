package com.psjj.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 执行顺序：
 *  1.前置通知
 *  2.目标方法
 *  3.最终通知
 *  4.后置通知
 *  5.环绕通知
 */
public class MyAdvice {
    //前置通知
    public void before(){
        System.out.println("前置通知增强中。。。 ");
    }
    //后置通知
    public void after(){
        System.out.println("后置通知增强中。。。 ");
    }
    //环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知start。。。");
        //执行目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知end。。。");
        return proceed;
    }
    //异常通知
    public void exception(Exception e){
        //打印异常信息
        System.out.println(e.getMessage());
        System.out.println("异常通知出现异常。。。");
    }
    //最终通知
    public void returnExecute (Object result){
        System.out.println("最终通知。。。返回结果为 "+result);
    }
}
