package com.example.demo.bean;

/**
 * @ClassName OrderInfo
 * @Author：Mayuan
 * @Date 2023/9/11/0011 14:55
 * @Description TODO
 * @Version 1.0
 **/
import java.util.Date;

public class OrderInfo {

    private int id;
    private String info;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", time=" + time +
                '}';
    }


}
