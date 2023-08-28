package com.example.redisdemo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Redisdemo1ApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final TimeUnit EXPIRE_TIME_TYPE = TimeUnit.DAYS;

    /**
     * 添加
     */
    @Test
    void add() {
        String key = "name";
        String value = "lisi";

        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 从redis中获取缓存数据
     */
    @Test
    void getString() {

        String key = "name";

        if (key != null && !"".equals(key)) {
            Object value = redisTemplate.opsForValue().get(key);
            System.out.println(value);
        }
    }

    /**
     * 写入 hash-set,已经是key-value的键值，不能再写入为hash-set
     */
    @Test
    void addHashCache() {
        String key = "names";
        String subKey = "fn";
        String value = "zhang";
        redisTemplate.opsForHash().put(key, subKey, value);
    }

    /**
     * 获取 hash-set value
     */
    @Test
    void getHashCache() {
        String key = "names";
        String subkey = "fn";
        Object value = redisTemplate.opsForHash().get(key,subkey);
        System.out.println(value);
    }

    /**
     * 存放List到Redis当中
     *
     * http://localhost:8088/getlist?key=testKey2
     */
    @Test
    void setList(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<>();
        list2.add("4");
        list2.add("5");
        list2.add("6");
        //往缓存右边一次性的存list数组
        redisTemplate.opsForList().rightPushAll("testKey1",list1);
        redisTemplate.opsForList().rightPushAll("testKey2",list2);
    }

    /**
     * 取List的值
     */
    @Test
    void getList(){
        String key = "testKey2";
        // 获取缓存的键的值的长度
        long size = redisTemplate.opsForList().size(key);
        System.out.println("集合的长度是："+size);
        // 获取缓存的List所有的值 -1 代表无线
        List<String> list = redisTemplate.opsForList().range(key,0,-1);
        System.out.println(list);
    }

    /**
     * 删除缓存中的某个键
     */
    @Test
    void delete(){
//        String key = "name";//删除字符串
//        String key = "names";//删除hashset
        String key = "testKey1";//删除集合
        //根据键删除值
        boolean flag = redisTemplate.delete(key);
        System.out.println(flag);


    }
}
