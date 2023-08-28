package com.example.redisdemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *
 * http://localhost:8088/redis?key=hi&value=hi
 */

@SpringBootApplication
@RestController
public class Redisdemo1Application {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main( String[] args) {
        SpringApplication.run(Redisdemo1Application.class,args);
    }

    /**
     * 从redis中获取缓存数据
     *
     * 访问方式
     * http://localhost:8088/getname?key=name
     */
    @GetMapping("/getname")
    public String getString(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value.toString();
    }


    /**
     *
     * @param key
     * @param value
     *
     * http://localhost:8080/setname?key=name&value=hello
     */
    @GetMapping("/setname")
    public void setString(String key,String value) {
        redisTemplate.opsForValue().set(key, value);
    }


    /**
     * http://localhost:8088/getlist?key=testKey2
     * @param key
     * @return
     */

    @GetMapping("/getlist")
    public List setString(String key) {
        long size = redisTemplate.opsForList().size(key);
        System.out.println(size);
        List list = redisTemplate.opsForList().range(key,0,-1);
        return list;
    }
}
