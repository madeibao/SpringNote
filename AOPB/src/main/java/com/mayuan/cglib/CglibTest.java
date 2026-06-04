package com.mayuan.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName CglibTest
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:52
 * @Description TODO
 * @Version 1.0
 **/
public class CglibTest {

    /**
     * 代理模式来实现AOP 的功能
     * 在需要使用 Hello 的时候，通过CGLIB动态代理获取代理对象
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        // 给目标对象创建一个代理对象
        Hello hello = (Hello) enhancer.create();
        hello.sayHello("Alan");
    }
}