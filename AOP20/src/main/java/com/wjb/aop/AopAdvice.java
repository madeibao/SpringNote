package com.wjb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @Description
 * @Author jianbo wang
 * @Date:2021/12/2 0002 8:03
 */
public class AopAdvice {


   //测试aop:before:
    public void before(){
        System.out.println("这是一个公共类前置方法before()");
    }
   //测试aop：around
    public Object  around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("执行在原始方法前"+"bbbbb");
        //不确认原始方法是否会有执行时异常，所以需要抛出异常
        Object res = pjp.proceed();
        System.out.println("执行在原始方法后"+res+"aaaaa");
        return res;
    }

    /**
     * 测试aop获取原始方法的参数
     * @param a
     * @param b
     */
    public  void afterPro(int a ,int b){
        System.out.println("这是公共方法***" +a+"***"+b);
    }
    public void beforePro(JoinPoint jp){
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
    }

    /**
     * 获取原始方法返回值
     * @param ret
     */
    public void afterPro01(Object ret){
        System.out.println("这是原始方法的返回值"+ret);
    }
    public Object aroundPro(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是执行原始方法前aaa");
        Object ret = pjp.proceed();
        System.out.println("这是执行原始方法后"+ret);
        return ret;
    }
}
