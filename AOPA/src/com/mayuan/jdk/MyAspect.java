package com.mayuan.jdk;

/**
 * @ClassName MyAspect
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:20
 * @Description TODO
 * @Version 1.0
 **/


public class MyAspect {
    public void myBefore() {
        System.out.println("方法执行之前");
    }

    public void myAfter() {
        System.out.println("方法执行之后");
    }
}
