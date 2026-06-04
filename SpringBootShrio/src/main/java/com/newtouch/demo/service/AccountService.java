package com.newtouch.demo.service;

import com.newtouch.demo.entity.Account;

/**
 * @ClassName AccountService
 * @Author：Mayuan
 * @Date 2023/8/31/0031 10:33
 * @Description TODO
 * @Version 1.0
 **/
public interface AccountService {
    Account findByUsername(String username);
}
