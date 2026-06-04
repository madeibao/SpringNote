package org.fluxtest.example;

/**
 * @ClassName ReactorElapsedExample
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:10
 * @Description TODO
 * @Version 1.0
 **/

import reactor.core.publisher.Flux;
import java.time.Duration;

public class ReactorElapsedExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> source = Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1));

        source.elapsed()
                .subscribe(tuple -> {
                    long elapsedTime = tuple.getT1();
                    int value = tuple.getT2();
                    System.out.println("Elapsed Time: " + elapsedTime + "ms, Value: " + value);
                });

        Thread.sleep(2333);
    }
}
