package com.psjj.annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//表示当前面是一个切面
public class MyAdvice {


    //配置公共切入点表达式
    @Pointcut("execution(* com.psjj.annotation.target.*Impl.*(..))")
    public void common(){}


    //前置通知
    @Before("execution(* com.psjj.annotation.target.*Impl.add(..))")
    public void before(){
        System.out.println("前置通知增强中。。。 ");
    }
    //后置通知
    @After("execution(* com.psjj.annotation.target.*Impl.del(..))")
    public void after(){
        System.out.println("后置通知增强中。。。 ");
    }
    //环绕通知
    @Around(value = "execution(* com.psjj.annotation.target.*Impl.update(..))",argNames = "joinPoint")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知start。。。");
        //执行目标方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知end。。。");
        return proceed;
    }
    //异常通知
    @AfterThrowing(value = "execution(* com.psjj.annotation.target.*Impl.update(..))",throwing = "e")
    public void exception(Exception e){
        //打印异常信息
        System.out.println(e.getMessage());
        System.out.println("异常通知出现异常。。。");
    }
    //最终通知
    @AfterReturning(value = "common()",returning = "result")
    public void returnExecute (Object result){
        System.out.println("最终通知。。。返回结果为 "+result);
    }
}



// <==before，前置通知加上了==>
// 删除方法执行了。。。
// <==afterReturning，后置通知加上了==>
// <==after，最终通知加上了==>
