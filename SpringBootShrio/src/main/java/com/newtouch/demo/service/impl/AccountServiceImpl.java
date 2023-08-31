package com.newtouch.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.newtouch.demo.entity.Account;
import com.newtouch.demo.mapper.AccountMapper;
import com.newtouch.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/31/0031 10:34
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public Account findByUsername(String username) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",username);
        return mapper.selectOne(wrapper);
    }
}
