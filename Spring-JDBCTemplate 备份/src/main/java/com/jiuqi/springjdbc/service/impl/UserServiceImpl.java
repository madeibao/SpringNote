package com.jiuqi.springjdbc.service.impl;

import com.jiuqi.springjdbc.dao.UserDao;
import com.jiuqi.springjdbc.entity.User;
import com.jiuqi.springjdbc.service.UserService;

import java.util.List;

/**
 * @author JiuQi 玖柒
 * @date 2021/5/13 20:05
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.sel();
    }

    @Override
    public int delUserById(int id) {
        return userDao.del(id);
    }
}
