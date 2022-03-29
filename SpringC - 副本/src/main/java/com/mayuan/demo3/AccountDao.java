package com.mayuan.demo3;

/**
 * @ClassName AccountDao
 * @Author：Mayuan
 * @Date 2022/3/10/0010 21:49
 * @Description TODO
 * @Version 1.0
 **/

public interface AccountDao {

    /**
     * @param out	:转出账号
     * @param money	:转账金额
     */
    public void outMoney(String out, double money);
    /**
     * @param in	:转入账号
     * @param money	:转账金额
     */
    public void inMoney(String in, double money);
}