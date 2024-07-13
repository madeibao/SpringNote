package org.webclient.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @ClassName ReactRest
 * @Author：Mayuan
 * @Date 2024/7/7/星期日 16:13
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class ReactRest {

    @GetMapping(path = "header")
    public Mono<String> header(@RequestHeader(name = "User-Agent") String userAgent,
                               @RequestHeader(name = "ck", required = false) String cookie) {
        return Mono.just("userAgent is: [" + userAgent + "] ck: [" + cookie + "]");
    }

    @GetMapping(path = "get")
    public Mono<String> get(String name, Integer age) {
        return Mono.just("req: " + name + " age: " + age);
    }

    @GetMapping(path = "mget")
    public Flux<String> mget(String name, Integer age) {
        return Flux.fromArray(new String[]{"req name: " + name, "req age: " + age});
    }

    /**
     * form表单传参，映射到实体上
     *
     * @param body
     * @return
     */
    @PostMapping(path = "post")
    public Mono<String> post(Body body) {
        return Mono.just("post req: " + body.getName() + " age: " + body.getAge());
    }

    // 请注意，这种方式和上面的post方法两者不一样，主要区别在Content-Type
    @PostMapping(path = "body")
    public Mono<String> postBody(@RequestBody Body body) {
        return Mono.just("body req: " + body);
    }

    // http://localhost:8080/webclienta postman 测试
    @GetMapping(path = "webclienta")
    public Optional<String> getResult() {
        WebClient webClient = WebClient.create("http://127.0.0.1:8080");
        // post body
        Body body = new Body();
        body.setName("一灰灰");
        body.setAge(18);
        Optional<String> ans = webClient.post().uri("/body").contentType(MediaType.APPLICATION_JSON).bodyValue(body).retrieve()
                .bodyToMono(String.class).blockOptional();
        return ans;
    }


}