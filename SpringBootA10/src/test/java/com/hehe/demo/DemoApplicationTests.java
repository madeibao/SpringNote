package com.hehe.demo;

import com.hehe.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DemoApplicationTests {

    @SuppressWarnings("all")
    @Autowired
    UserMapper userMapper;

    @Test
    public void test_db() {

        //开始进行测试
        assertThat(userMapper.list().size()).isGreaterThan(1);
        assertThat(userMapper.getOne("1")).isNotEqualTo(null);
        assertThat(userMapper.getOne("xxx")).isEqualTo(null);



    }


}
