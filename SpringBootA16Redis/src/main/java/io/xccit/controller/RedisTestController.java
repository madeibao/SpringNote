package io.xccit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisTestController
 * @Author：Mayuan
 * @Date 2023/8/22/0022 17:46
 * @Description TODO
 * @Version 1.0
 **/


@RestController
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @GetMapping("/redis")
    public String getName() {
        return redisTemplate.opsForValue().get("name");
    }
}
