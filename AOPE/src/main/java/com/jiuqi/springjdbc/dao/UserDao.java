package com.jiuqi.springjdbc.dao;

import com.jiuqi.springjdbc.entity.User;

import java.util.List;

/**
 * @author JiuQi 玖柒
 * @date 2021/5/13 19:06
 */
public interface UserDao {
    int save(User user);

    int update(User user);

    List<User> sel();

    int del(int id);
}
