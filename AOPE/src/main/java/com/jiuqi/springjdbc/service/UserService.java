package com.jiuqi.springjdbc.service;

import com.jiuqi.springjdbc.entity.User;

import java.util.List;

/**
 * @author JiuQi 玖柒
 * @date 2021/5/13 20:05
 */
public interface UserService {

    int save(User user);

    int update(User user);

    List<User> findAll();

    int delUserById(int id);
}
