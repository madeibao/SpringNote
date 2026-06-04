package com.example.anno;

import org.springframework.stereotype.Component;

/**
 * @Author :mayuan
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i = 1/0;
        System.out.println("save running ...");
    }
}
