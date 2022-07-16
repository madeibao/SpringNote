package com.psjj.xml.target;

public class UserDaoImpl implements UserDao{


    @Override
    public void add() {
        System.out.println("增加方法");
    }

    @Override
    public void del() {
        System.out.println("删除方法");
    }

    @Override
    public void update() {
        System.out.println("修改方法");
    }

    @Override
    public String query() {
        System.out.println("查询方法");
        return "data";
    }
}
