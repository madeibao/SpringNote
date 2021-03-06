package com.jk.annotation.service;

public interface AccountService {
    /**
     * 保存模拟
     */
    void saveAccount();

    /**
     * 模拟工薪
     * @param id
     */
    void updateAccount(int id);

    /**
     * 模拟删除
     * @return
     */
    int deleteAccount();
}
