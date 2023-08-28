package com.example.demo.dao;

import com.example.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DemoDaoUseJdbcTemplate
 * @Author：Mayuan
 * @Date 2023/8/15/0015 17:41
 * @Description TODO
 * @Version 1.0
 **/


@Repository("demoDao1")
public class DemoDaoUseJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Demo getById(Integer id) {
        String sql = "select * from demo where id = ?";
        //获取数据映射
        RowMapper<Demo> mapper =  new BeanPropertyRowMapper<>(Demo.class);

        return jdbcTemplate.queryForObject(sql,mapper,id);
    }
}
