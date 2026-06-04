package com.example.demo.service;

import com.example.demo.dao.DemoDaoUseJdbcTemplate;
import com.example.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoService2
 * @Author：Mayuan
 * @Date 2023/8/15/0015 17:41
 * @Description TODO
 * @Version 1.0
 **/

@Service("demoService2")
public class DemoService2 {

    @Autowired
    private DemoDaoUseJdbcTemplate daoUseJdbcTemplate;
    public Demo getById(Integer id) {

        return daoUseJdbcTemplate.getById(id);
    }
}
