package com.mvca.www;

/**
 * @ClassName UserInfoDto
 * @Author：Mayuan
 * @Date 2024/7/28/星期日 21:57
 * @Description TODO
 * @Version 1.0
 **/
public class UserInfoDto {
    //姓名
    private String name;
    //年龄
    private Integer age;

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
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

