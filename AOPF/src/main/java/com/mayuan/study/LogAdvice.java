package com.mayuan.study;

/**
 * @ClassName LogAdvice
 * @Author：Mayuan
 * @Date 2022/4/6/0006 22:28
 * @Description TODO
 * @Version 1.0
 **/
public class LogAdvice {
    public void logBeforeMethod() {
        System.out.println("方法执行前，日志输出");
    }

    public void logAfterMethod() {
        System.out.println("方法执行后，日志输出");
    }
}
