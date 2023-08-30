package cn.chenjiajin.domain;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:39
 * @Description TODO
 * @Version 1.0
 **/
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    // 二级缓存需要将内存中的对象信息存储到磁盘里面,需要序列化操作
    // 缓存的对象必须实现序列化。因为二级缓存的数据不一定都是存储到内存中，它的存储介质多种多样，所以需要给缓存的对象执行序列化，才可以确保获取无误。
    private int id;
    private String name;
    private int age;


}
