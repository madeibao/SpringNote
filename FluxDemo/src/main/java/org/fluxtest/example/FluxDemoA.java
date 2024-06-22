package org.fluxtest.example;

import reactor.core.publisher.Flux;

/**
 * @ClassName FluxDemoA
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:41
 * @Description TODO
 * @Version 1.0
 **/
public class FluxDemoA {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(0, 10);
        flux.subscribe(i -> {
            System.out.println("run1: " + i);
        });
        flux.subscribe(i -> {
            System.out.println("run2: " + i);
        });
    }
}
