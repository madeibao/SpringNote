package com.example.demo.mapper;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/9/16/0016 19:57
 * @Description TODO
 * @Version 1.0
 **/

@Mapper
public interface UserMapper {
    User findByName(String name);
    User findById(Integer id);
}
