package org.fluxtest.example;

import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ClassName MonoDemo2
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:25
 * @Description TODO
 * @Version 1.0
 **/
public class MonoDemo2 {

    void contextLoads() {
        //恶汉型：比较霸道，只创建一次
        Mono<Date> m1 = Mono.just(new Date());
        //懒汉型：比较懒，每次调用才创建
        Mono<Date> m2 = Mono.defer(() -> Mono.just(new Date()));
        m1.subscribe(System.out::println);
        m2.subscribe(System.out::println);
        //延迟5秒钟
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1.subscribe(System.out::println);
        m2.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        new MonoDemo2().contextLoads();
    }
}
