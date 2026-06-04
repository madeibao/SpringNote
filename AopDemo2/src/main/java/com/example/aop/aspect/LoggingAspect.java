package com.example.aop.aspect;

/**
 *
 * @ClassName LoggingAspect
 * @Author Mayuan
 * @Date 2026/6/4/星期四 11:05
 * @Version 1.0
 **/
import com.example.aop.annotation.NeedLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    /**
     * 方式一：基于注解的切点 - 只有标记了 @NeedLog 的方法才会被增强
     */
    @Pointcut("@annotation(needLog)")
    public void annotationPointcut(NeedLog needLog) {}

    /**
     * 方式二：基于表达式的切点 - 匹配 service 包下的所有方法
     */
    @Pointcut("execution(* com.example.aop.service.*.*(..))")
    public void servicePointcut() {}

    /**
     * 前置通知 - 在目标方法执行前执行
     */
    @Before("servicePointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("【前置通知】准备执行方法: " + methodName +
                ", 参数: " + Arrays.toString(args));
    }

    /**
     * 后置通知 - 在目标方法正常执行完成后执行
     */
    @AfterReturning(pointcut = "servicePointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【后置通知】方法: " + methodName +
                " 执行完成, 返回结果: " + result);
    }

    /**
     * 异常通知 - 当目标方法抛出异常时执行
     */
    @AfterThrowing(pointcut = "servicePointcut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【异常通知】方法: " + methodName +
                " 抛出了异常: " + error.getMessage());
    }

    /**
     * 最终通知 - 无论是否异常都会执行（类似 finally）
     */
    @After("servicePointcut()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("【最终通知】方法: " + methodName + " 执行完毕");
    }

    /**
     * 环绕通知 - 最强大的通知类型，可以完全控制目标方法的执行
     */
    @Around("@annotation(needLog)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, NeedLog needLog)
            throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String logValue = needLog.value();

        long startTime = System.currentTimeMillis();
        System.out.println("【环绕通知开始】方法: " + methodName + ", 日志标记: " + logValue);

        Object result = null;
        try {
            // 执行目标方法
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            System.out.println("【环绕通知结束】方法: " + methodName +
                    " 执行耗时: " + (endTime - startTime) + "ms");
            return result;
        } catch (Exception e) {
            System.out.println("【环绕通知异常】方法: " + methodName +
                    " 发生异常: " + e.getMessage());
            throw e;
        }
    }
}