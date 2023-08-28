package com.mayuan.pagetest.service;

import com.mayuan.pagetest.model.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserService
 * @Author：Mayuan
 * @Date 2023/8/18/0018 10:01
 * @Description TODO
 * @Version 1.0
 **/

public interface IUserService {
    List<User> pagerFind(Map map);
    void insert(User user);
    void delete(int id);
}
