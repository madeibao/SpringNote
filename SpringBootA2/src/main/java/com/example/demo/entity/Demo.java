package com.example.demo.entity;

/**
 * @ClassName Demo
 * @Author：Mayuan
 * @Date 2023/8/15/0015 15:43
 * @Description TODO
 * @Version 1.0
 **/
public class Demo {
    /**
     *     主键.
     */

    private long id;

    /**
     * 测试名称
     */
    private String name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
