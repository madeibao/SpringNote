package org.example.service;

import org.example.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName Service
 * @Author：Mayuan
 * @Date 2024/6/2/星期日 17:57
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class TestService {

    @Autowired
    Person person;

    public void test(){
        System.out.println(person);
    }

//
//    @Autowired
//    Person person2;
//
//    public void test2() {
//        System.out.println(person2);
//    }

}
