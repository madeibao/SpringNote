package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:23
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService{

    public static final String CACHE_KEY_USER="user";

    @Autowired
    private UserMapper userMappper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void createUser(User user) {

        userMappper.insertSelective(user);
        //缓存key
        String key=CACHE_KEY_USER+user.getId();
        user=userMappper.selectByPrimaryKey(user.getId());
        System.out.println(user.getId());
        System.out.println(user.toString());
        redisTemplate.opsForValue().set(key,user);
    }

    @Override
    public User findUserById(int id) {
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        //缓存key
        String key=CACHE_KEY_USER+id;
        //先去redis中查，如果查到直接返回，没有的话再去数据库中查询
        User user=valueOperations.get(key);
        System.out.println("45行"+user.toString());
        if(user==null){
            user=userMappper.selectByPrimaryKey(id);
            System.out.println("48行"+user.toString());
            valueOperations.set(key,user);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        userMappper.updateByPrimaryKeySelective(user);
        //缓存key
        String key=CACHE_KEY_USER+user.getId();
        user=userMappper.selectByPrimaryKey(user.getId());
        redisTemplate.opsForValue().set(key,user);
    }
}
