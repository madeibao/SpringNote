package com.example.demo;

import com.example.demo.util.SerializuUtil;
import com.example.demo.config.RedisConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.SetParams;

import com.example.demo.pojo.StudentA;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void initCount() {
        // 创建redis 对象 连接redis 服务器
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123456");
        jedis.select(1);
        String res = jedis.ping();
        System.out.println(res);
        jedis.set("name", "zhangSan");
        System.out.println(jedis.get("name"));
        if (jedis != null) {
            jedis.close();
        }
    }

    // jedis 连接池操作
    @Test
    void initConnt02() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379, 10000, "123456");
//        从连接词获取jedis对象
        Jedis resource = jedisPool.getResource();
        resource.select(2);
        System.out.println(resource.ping());
        resource.set("name", "zhang");
        System.out.println(resource.get("name"));
        if (resource != null) {
            resource.close();
        }
    }

    private Jedis jedis = null;
    @Autowired
    private JedisPool jedisPool;


    @BeforeEach
    public void initConnt3() {
        jedis = jedisPool.getResource();
    }

    @AfterEach
    public void closeConnt() {
        if (null != jedis) {
            jedis.close();
        }
    }


    @Test
//    操作String
    public void testString() {
        jedis.set("name", "zhangsan2");
        System.out.println(jedis.get("name"));

        jedis.mset("address", "sh", "sex", "1");
        List<String> mget = jedis.mget("name", "address", "sex");
        mget.forEach(System.out::println);

        jedis.del("name");
    }


    @Test
    public void testHash() {
        jedis.hset("user", "name", "李卫东");
        System.out.println(jedis.hget("user", "name"));
        Map<String, String> objectMap = new HashMap<>();
        objectMap.put("age", "20");
        objectMap.put("sex", "女");
        objectMap.put("name", "灵儿");

        jedis.hmset("user", objectMap);
        List<String> user = jedis.hmget("user", "age", "sex");
        user.forEach(System.out::println);
        Map<String, String> user1 = jedis.hgetAll("user");
        user1.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "--->" + e.getValue());
        });
        jedis.hdel("user", "name");
    }

    @Test
    public void testList() {
        jedis.lpush("students", "zhangsan", "lisi");
        jedis.rpush("students", "wangwu", "zhaoliu");
        List<String> students = jedis.lrange("students", 0, 3);
        students.forEach(System.out::println);
        Long students1 = jedis.llen("students");
        System.out.println("个数为:" + students1);

        jedis.lrem("students", 1, "lisi");


//        左弹出  获取 最左边的数据打印出来，并删除数据库对应的数据
        String students3 = jedis.lpop("students");
        System.out.println(students3);

    }


    @Test
    public void testSet() {
        jedis.sadd("letters", "aaa", "bbb", "ccc", "ddd");

        Set<String> letters = jedis.smembers("letters");
        letters.forEach(System.out::println);

        jedis.srem("letters", "ccc");

        Long letters1 = jedis.scard("letters");
        System.out.println("获取的条数为" + letters1);
    }

    /**
     * sorted set
     */
    @Test
    public void sortedSet() {
        jedis.zadd("studentA", 1, "张三");
        jedis.zadd("studentA", 3, "李四");
        jedis.zadd("studentA", 2, "王五");

        long zrem = jedis.zrem("studentA", "王五");
        System.out.println(zrem);
        List<String> user = jedis.zrange("studentA", 0, -1);
        user.forEach(s -> System.out.println(s));
        jedis.close();

    }

    /**
     * 层级目录
     */
    @Test
    public void testDir() {
        jedis.set("cart:user01:item01", "apple");
        System.out.println(jedis.get("cart:user01:item01"));
    }

    //    失效时间
    @Test
    public void testExpire() {
////        给已经存在的key设置失效时间
//        jedis.set("code","test");
////        设置失效时间单位秒
//        jedis.expire("code",Long.valueOf(30));
////        毫秒
//        jedis.pexpire("code",Long.valueOf(30000));
////        查看失效时间
//        Long code = jedis.ttl("code");
//        System.out.println(code);

        //      添加key的时候  设置失效时间单位秒


//jedis.setex("code",Long.valueOf(30),"test");
////毫秒
//jedis.psetex("code",Long.valueOf(30000),"test");
//        Long code = jedis.pttl("code");
//        System.out.println(code);


        SetParams setParams = new SetParams();
        //       nx 不存在时成功运行
        setParams.nx();
//        setParams.xx();
//        setParams.ex(Long.valueOf(30));
        setParams.px(Long.valueOf(30000));
        jedis.set("code", "test", setParams);
    }

    @Test
    public void testAllKey(){
        System.out.println( jedis.dbSize());

//        * 可以写正则表达式
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
    }


    @Test
    public void testMulti() {
        Transaction multi = jedis.multi();
        multi.set("te1","10059");
//        提交事务
        multi.exec();
//        回滚事务
//        multi.discard();
    }

    /**
     * 操作byte 数组
     */
    @Test
    public void testByte() {
        StudentA user=new StudentA(1,"zhangsan","123");
        //将对象序列化为byte 数组
        byte[] userKey = SerializuUtil.serialize("user:" + user.getId());
        byte[] serialize = SerializuUtil.serialize(user);

        jedis.set(userKey,serialize);
        byte[] bytes = jedis.get(userKey);
        //反序列化byte数组
        StudentA user1 = (StudentA) SerializuUtil.unserialize(bytes);
        System.out.println(user1);

    }

}
