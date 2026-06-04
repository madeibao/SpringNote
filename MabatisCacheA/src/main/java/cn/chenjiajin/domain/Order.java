package cn.chenjiajin.domain;

/**
 * @ClassName Order
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:38
 * @Description TODO
 * @Version 1.0
 **/
import lombok.Data;

import java.io.Serializable;


@Data
public class Order implements Serializable {

    private int id;
    private String orderTime;
    private double total;

    private User user;
}
