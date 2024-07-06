package org.jsonproperty.example;

/**
 * @ClassName JSONFieldData
 * @Author：Mayuan
 * @Date 2024/7/6/星期六 12:04
 * @Description TODO
 * @Version 1.0
 **/

import com.alibaba.fastjson.annotation.JSONField;

public class JSONFieldData {
    @JSONField(name = "my_name")
    private String name;
    private String phone;
    @JSONField(name = "my_age")
    private Integer age;

    public JSONFieldData() {
    }

    public JSONFieldData(String name, String phone, Integer age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "JSONFieldData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
