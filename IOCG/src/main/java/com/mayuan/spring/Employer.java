package com.mayuan.spring;

/**
 * @ClassName Employer
 * @Author：Mayuan
 * @Date 2022/1/23/0023 13:17
 * @Description TODO0
 * @Version 1.
 **/
public class Employer {
    private Department dept;

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "dept=" + dept +
                '}';
    }
}
