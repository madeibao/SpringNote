package com.jk.xml.service;

import com.jk.xml.entity.Account;

/**
 * @author ASUS
 */
public interface AccountService {
    /**
     * 模拟保存
     */
    void saveAccount();

    /**
     * 模拟更新
     * @param id
     */
    void updateAccount(int id);

    /**
     * 模拟删除
     * @return
     */
    int deleteAccount();

    /**
     * 多个参数基本类型
     * @param id
     * @param name
     * @return
     */
    String moreArgs(int id, String name);

    /**
     * 引用参数类型
     * @param account
     */
    void objArgs(Account account);
}
