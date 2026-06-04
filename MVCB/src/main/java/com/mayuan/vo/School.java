package com.mayuan.vo;

/**
 * @ClassName School
 * @Author：Mayuan
 * @Date 2023/8/12/0012 10:42
 * @Description TODO
 * @Version 1.0
 **/
public class School {
    private String sName;
    private String sAddress;

    public School() {
    }

    public School(String sName, String sAddress) {
        this.sName = sName;
        this.sAddress = sAddress;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    @Override
    public String toString() {
        return "School{" +
                "sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                '}';
    }
}
