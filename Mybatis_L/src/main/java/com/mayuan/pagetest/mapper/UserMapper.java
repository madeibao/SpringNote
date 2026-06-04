package com.mayuan.pagetest.mapper;

import com.mayuan.pagetest.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/8/18/0018 9:44
 * @Description TODO
 * @Version 1.0
 **/

@Mapper
public interface UserMapper {
    List<User> pagerFind(Map map);
    void insert(User user);
    void delete(int id);
    void updateName(String loginName);
}
