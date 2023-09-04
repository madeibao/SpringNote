package com.newtouch.demo;

import com.newtouch.demo.mapper.AccountMapper;
import com.newtouch.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private AccountMapper mapper;
    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void test(){
        System.out.println(accountService.findByUsername("ls"));
    }
}
