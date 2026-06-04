package org.fluxtest.example;

import reactor.core.publisher.Mono;

/**
 * @ClassName MonoDemo3
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:35
 * @Description TODO
 * @Version 1.0
 **/
public class MonoDemo3 {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello").map(s -> s + ", world!").flatMap(s -> Mono.just(s.toUpperCase()));
        mono.subscribe(System.out::println);
    }
}
