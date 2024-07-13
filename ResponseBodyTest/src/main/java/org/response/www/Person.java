package org.response.www;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 22:21
 * @Description TODO
 * @Version 1.0
 **/

public class Person {
    Integer id;
    String name;
    Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}