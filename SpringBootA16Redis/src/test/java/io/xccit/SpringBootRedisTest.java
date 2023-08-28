package io.xccit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName SpringBootRedisTest
 * @Author：Mayuan
 * @Date 2023/8/22/0022 17:47
 * @Description TODO
 * @Version 1.0
 **/


@SpringBootTest
public class SpringBootRedisTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void fun1(){
        //存
        redisTemplate.opsForValue().set("name","lucy");
        //取
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}