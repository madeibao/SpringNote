package org.example.bean;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2024/6/2/星期日 17:55
 * @Description TODO
 * @Version 1.0
 **/

public class Person {

    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
