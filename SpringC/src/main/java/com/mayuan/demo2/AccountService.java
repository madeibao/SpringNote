package com.mayuan.demo2;

/**
 * @ClassName AccountService
 * @Author：Mayuan
 * @Date 2022/3/10/0010 21:51
 * @Description TODO
 * @Version 1.0
 **/

public interface AccountService {
    /**
     * @param in 	:转入帐号
     * @param out	:转出账号
     * @param money	:转账金额
     */
    public void transfer(String in, String out, double money);
}