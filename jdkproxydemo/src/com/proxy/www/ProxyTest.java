package com.proxy.www;

import com.proxy.www.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * 原生 JDK 动态代理, 实现 SpringAOP 的功能
 *
 * @ClassName ProxyTest
 * @Author Mayuan
 * @Date 2026/9/9/星期三 20:28
 * @Version 1.0
 **/
public class ProxyTest {
    public static void main(String[] args) {
        // 1. 目标对象
        UserService target = new UserServiceImpl();
        // 2. 调用处理器
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 3. 动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),     // 类加载器
                target.getClass().getInterfaces(),      // 目标实现的接口
                handler                                 // 调用处理器
        );

        // 调用代理方法，会进入invoke
        proxy.addUser();
        System.out.println("========");
        proxy.deleteUser();
    }
}
