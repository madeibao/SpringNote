package com.mayuan.spring;

/**
 * @ClassName Address
 * @Author：Mayuan
 * @Date 2022/1/23/0023 18:18
 * @Description TODO
 * @Version 1.0
 **/

public class Address {

    private String city;
    private String street;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", street=" + street + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
