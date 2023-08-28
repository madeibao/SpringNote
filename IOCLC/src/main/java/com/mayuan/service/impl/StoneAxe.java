package com.mayuan.service.impl;

import com.mayuan.service.Axe;
import org.springframework.stereotype.Component;

/**
 * @ClassName StoneAxe
 * @Author：Mayuan
 * @Date 2022/1/24/0024 22:25
 * @Description TODO
 * @Version 1.0
 **/


@Component
public class StoneAxe implements Axe {
    public String chop()
    {
        return "石斧砍柴好慢";
    }
}