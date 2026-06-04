package com.southwind.repository;

import com.southwind.entity.Account;

import java.util.List;

/**
 * @ClassName AccountRepository
 * @Author：Mayuan
 * @Date 2020/12/24/0024 21:48
 * @Description TODO
 * @Version 1.0
 **/

public interface AccountRepository {

    public int save(Account account);

    public int update(Account account);

    public int deleteById(long id);

    public List<Account> findAll();

    public Account findById(long id);

    public Account findByName(String name);

}
