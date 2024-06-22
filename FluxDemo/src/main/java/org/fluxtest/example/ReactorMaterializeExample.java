package org.fluxtest.example;

/**
 * @ClassName ReactorMaterializeExample
 * @Author：Mayuan
 * @Date 2024/6/22/星期六 17:14
 * @Description TODO
 * @Version 1.0
 **/
import reactor.core.publisher.Flux;

public class ReactorMaterializeExample {
    public static void main(String[] args) {
        Flux<Integer> source = Flux.just(1, 2, 0, 4, 5);

        // 将正常元素和错误信息封装为通知对象
        source.map(x -> 10 / x)
                .materialize()
                .subscribe(System.out::println);
    }
}
