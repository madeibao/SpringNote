package com.mayuan.spring;

/**
 * @ClassName Car
 * @Author：Mayuan
 * @Date 2022/1/23/0023 18:18
 * @Description TODO
 * @Version 1.0
 **/
public class Car {

    private String brand;
    private double price;
    // 调用静态方法或静态属性：通过 T() 调用一个类的静态方法，它将返回一个 Class Object，然后再调用相应的方法或属性
    private long weight;

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", price=" + price + ", weight=" + weight + "]";
    }


}
