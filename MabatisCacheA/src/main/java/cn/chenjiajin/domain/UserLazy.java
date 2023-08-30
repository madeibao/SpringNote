package cn.chenjiajin.domain;

/**
 * @ClassName UserLazy
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:39
 * @Description TODO
 * @Version 1.0
 **/

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 延迟加载
 */
@Data
public class UserLazy implements Serializable {

    private int id;
    private String name;
    private int age;
    private List<Order> orderList = new ArrayList<>();


    @Override
    public String toString() {
        return "UserLazy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
