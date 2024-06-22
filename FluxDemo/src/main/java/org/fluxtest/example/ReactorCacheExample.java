package org.fluxtest.example;

/**
 * @ClassName ReactorCacheExample
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:13
 * @Description TODO
 * @Version 1.0
 **/
import reactor.core.publisher.Flux;

public class ReactorCacheExample {
    public static void main(String[] args) {
        Flux<Integer> source = Flux.range(1, 3).log() //日志
                .cache();
        source.subscribe(System.out::println); // 输出: 1, 2, 3
        source.subscribe(System.out::println); // 输出: 1, 2, 3 直接从缓存中取，日志中显示，未调用request、onNext等方法
    }
}
