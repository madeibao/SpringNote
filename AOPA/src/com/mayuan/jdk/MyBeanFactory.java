package com.mayuan.jdk;

/**
 * @ClassName MyBeanFactory
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:20
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.dao.CustomerDao;
import com.mayuan.dao.CustomerDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyBeanFactory {

    public static CustomerDao getBean() {
        // 准备目标类
        final CustomerDao customerDao = new CustomerDaoImpl();
        // 创建切面类实例
        final MyAspect myAspect = new MyAspect();
        // 使用代理类，进行增强
        return (CustomerDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                new Class[] { CustomerDao.class }, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.myBefore(); // 前增强
                        Object obj = method.invoke(customerDao, args);
                        myAspect.myAfter(); // 后增强
                        return obj;
                    }
                });
    }
}
