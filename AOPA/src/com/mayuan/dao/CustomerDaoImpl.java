package com.mayuan.dao;

/**
 * @ClassName CustomerDaoImpl
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:18
 * @Description TODO
 * @Version 1.0
 **/
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void add() {
        System.out.println("添加客户...");
    }

    @Override
    public void update() {
        System.out.println("修改客户...");
    }

    @Override
    public void delete() {
        System.out.println("删除客户...");
    }

    @Override
    public void find() {
        System.out.println("修改客户...");
    }
}
