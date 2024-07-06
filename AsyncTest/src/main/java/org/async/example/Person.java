package org.async.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2024/7/6/星期六 11:21
 * @Description TODO
 * @Version 1.0
 **/

@Component
public class Person {

    @Async
    public void show(String name) {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("======>show...");
    }
}