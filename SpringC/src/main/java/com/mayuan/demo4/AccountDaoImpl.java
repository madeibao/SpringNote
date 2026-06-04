package com.mayuan.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @ClassName AccountDaoImpl
 * @Author：Mayuan
 * @Date 2022/3/10/0010 21:49
 * @Description TODO
 * @Version 1.0
 **/


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    /**
     * @param out	:转出账号
     * @param money	:转账金额
     */
    @Override
    public void outMoney(String out, double money) {
        String sql="update account set money=money-? where name=?";
        this.getJdbcTemplate().update(sql, money, out);
    }

    /**
     * @param in	:转入账号
     * @param money	:转账金额
     */
    @Override
    public void inMoney(String in, double money) {
        String sql = "update account set money=money+? where name=?";
        this.getJdbcTemplate().update(sql, money, in);
    }

}
