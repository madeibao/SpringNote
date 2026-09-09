package com.proxy.www;

/**
 *
 * @ClassName MyInvocationHandler
 * @Author Mayuan
 * @Date 2026/9/9/星期三 20:27
 * @Version 1.0
 **/
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 代理对象
     * @param method 被调用的方法
     * @param args 方法参数
     * @return 方法返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // ========== 前置通知 ==========
        System.out.println("【JDK代理增强】方法执行前：记录日志");

        // 执行目标对象真实方法
        Object result = method.invoke(target, args);

        // ========== 后置通知 ==========
        System.out.println("【JDK代理增强】方法执行后：记录日志");
        return result;
    }
}
