package org.fluxtest.example;

/**
 * @ClassName MonoExample
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:17
 * @Description TODO
 * @Version 1.0
 **/

import reactor.core.publisher.Mono;

public class MonoExample {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello, World!");

        mono.subscribe(System.out::println, // 成功的onNext处理
                System.err::println, // 处理错误
                () -> System.out.println("Completed.") // 完成的处理
        );

        Mono<String> mono2 = Mono.just("Hello").map(s -> s + ", world!").flatMap(s -> Mono.just(s.toUpperCase()));
        mono2.subscribe(System.out::println);
    }
}