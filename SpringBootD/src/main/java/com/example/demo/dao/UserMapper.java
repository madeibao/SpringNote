package com.example.demo.dao;

import com.example.demo.base.dao.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:41
 * @Description TODO
 * @Version 1.0
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
