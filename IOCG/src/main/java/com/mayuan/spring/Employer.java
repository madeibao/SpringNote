package com.mayuan.spring;

import org.springframework.stereotype.Component;

/**
 * @ClassName Employer
 * @Author：Mayuan
 * @Date 2022/1/23/0023 13:17
 * @Description TODO0
 * @Version 1.
 **/

@Component(value = "employer")
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
