package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootLearningApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void listTest() {
        List<User> list = userMapper.list();

        assert list.size() != 0;
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setName("张三"+Math.random());
        user.setAge(19);
        int result = userMapper.save(user);
        assert result == 1;
    }


    @Test
    void deleteUser() {
        int result = userMapper.delete(3);
        assert result == 1;
    }


    @Test
    void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三"+Math.random());
        user.setAge(29);
        int result = userMapper.update(user);
        assert result == 1;
    }


    @Test
    void findUser(){
        User user = userMapper.findById(2);
        assert user.getName()!=null;
    }
}
