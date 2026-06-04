package com.mayuan.demo3;

/**
 * @ClassName AccountServiceImpl
 * @Author：Mayuan
 * @Date 2022/3/12/0012 9:55
 * @Description TODO
 * @Version 1.0
 **/
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void transfer1(String in, String out, double money) {
        accountDao.outMoney(out, money);
        accountDao.inMoney(in, money);
    }

    @Override
    public void transfer(String in, String out, double money) {

        accountDao.outMoney(out, money);
        //int a= 1/0;//测试事务回滚
        accountDao.inMoney(in, money);

    }

}
