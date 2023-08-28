package com.wqh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

public class LogInterceptor {

    /**
     * 前置通知:在方法前执行的代码
     * @param joinPoint
     */
    public void beforeExecute(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println(this.getClass().getSimpleName()+" before execute");
    }

    /**
     * 后置通知:在方法执行后执行的代码(无论改方法是否发生异常),注意后置通知拿不到执行的结果
     * @param joinPoint
     */
    public void afterExecute(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(this.getClass().getSimpleName()+" after execute");
    }

    /**
     * 后置返回通知: 在方法正常执行后执行的代码,可以获取到方法的返回值
     * @param joinPoint
     * @param object
     */
    public void afterReturning(JoinPoint joinPoint,Object object){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(this.getClass().getSimpleName()+" afterReturning execute, result:"+object);
    }

    /**
     * 后置异常通知: 在方法抛出异常之后执行,可以访问到异常信息,且可以指定出现特定异常信息执行代码
     * @param joinPoint
     * @param ex
     */
    public void afterThrowing (JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(this.getClass().getSimpleName()+" afterThrowing execute, exception:"+ex);
    }

    /**
     * 环绕通知,围绕着方法执行
     * @param joinPoint
     * @return
     */
    public Object around(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(this.getClass().getSimpleName()+" around execute start");

        Object result = null;
        try {
            //执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
