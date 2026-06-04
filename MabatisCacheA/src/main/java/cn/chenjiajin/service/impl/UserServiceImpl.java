package cn.chenjiajin.service.impl;

/**
 * @ClassName UserServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:31
 * @Description TODO
 * @Version 1.0
 **/
import cn.chenjiajin.domain.User;
import cn.chenjiajin.domain.qo.PageResult;
import cn.chenjiajin.domain.qo.QueryObject;
import cn.chenjiajin.mapper.UserMapper;
import cn.chenjiajin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public void insert(User User) {
        userMapper.insert(User);
    }

    @Override
    public User select(Long id) {
        return userMapper.select(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void update(User User) {
        userMapper.update(User);
    }

    @Override
    public int selectForCount(QueryObject qo) {
        return userMapper.selectForCount(qo);
    }

    @Override
    public PageResult<User> selectForList(QueryObject qo) {
        return new PageResult<>(qo.getCurrentPage(), qo.getPageSize(), userMapper.selectForList(qo), userMapper.selectForCount(qo));
    }
}
