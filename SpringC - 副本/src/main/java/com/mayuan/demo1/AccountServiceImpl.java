package com.mayuan.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @ClassName AccountServiceImpl
 * @Author：Mayuan
 * @Date 2022/3/10/0010 21:52
 * @Description TODO
 * @Version 1.0
 **/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //注入事务管理的模板
    private TransactionTemplate TransactionTemplate;


    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        TransactionTemplate = transactionTemplate;
    }


    public void transfer1(String in, String out, double money) {
        accountDao.outMoney(out, money);
        accountDao.inMoney(in, money);
    }

    @Override
    public void transfer(String in, String out, double money) {
        TransactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                accountDao.outMoney(out, money);
                //int a= 1/0;//测试事务回滚
                accountDao.inMoney(in, money);
            }
        });
    }

}
