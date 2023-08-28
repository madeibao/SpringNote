package com.mayuan.test3;

import com.mayuan.dao.config.SpringConfig;
import com.mayuan.dao.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
/**
 * @ClassName AopAnnotationTest2
 * @Author：Mayuan
 * @Date 2022/4/16/0016 21:54
 * @Description TODO
 * @Version 1.0
 **/
@SpringJUnitConfig(classes = SpringConfig.class)
public class AopAnnotationTest2 {

    @Autowired
    public AccountService as;

    @Test
    public void fullAnnotation() {
        as.saveAccount();
    }
}