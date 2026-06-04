package com.mayuan.cglib;

/**
 * @ClassName CglibMethodInterceptor
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:51
 * @Description TODO
 * @Version 1.0
 **/

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 实现一个MethodInterceptor，方法调用会被转发到该类的intercept()方法。
 * @author ASUS
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept param is " + Arrays.toString(args));
        System.out.println("before===============" + method);
        // 这里可以实现增强的逻辑处理s
        Object result = methodProxy.invokeSuper(obj, args);
        // 这里可以实现增强的逻辑处理
        System.out.println("after===============" + method);
        return result;
    }

}