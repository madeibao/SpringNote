package com.mayuan.spring;

/**
 * @ClassName MyBeanPostProcessor
 * @Author：Mayuan
 * @Date 2022/1/23/0023 17:18
 * @Description TODO
 * @Version 1.0
 **/


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)  throws BeansException {
        System.out.println("before init..........."+arg0.getClass());
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)  throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("after init..........."+arg0.getClass());
        return arg0;
    }

}