package com.mayuan.service.impl;

import com.mayuan.service.Axe;
import org.springframework.stereotype.Component;

/**
 * @ClassName SteelAxe
 * @Author：Mayuan
 * @Date 2022/1/24/0024 22:24
 * @Description TODO
 * @Version 1.0
 **/
@Component
public class SteelAxe implements Axe {
    public String chop() {
        return "钢斧砍柴真快";
    }
}
