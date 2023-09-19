package com.mayuan.service;

import com.mayuan.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @Author：Mayuan
 * @Date 2023/9/17/0017 15:46
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class TestService {

    @Autowired
    @Qualifier("person2")
    Person person;

    public void test() {
        System.out.println(person);
    }

}