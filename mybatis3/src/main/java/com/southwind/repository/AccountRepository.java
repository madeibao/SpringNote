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

    int save(Account account);

    int update(Account account);

    int deleteById(long id);

    List<Account> findAll();

    Account findById(long id);

    Account findByName(String name);

}
