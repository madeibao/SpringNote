package com.future.www;

/**
 * @ClassName MainTest
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 17:18
 * @Description TODO
 * @Version 1.0
 **/
public class MainTest {
    public static void main(String[] args) {
        FutureClient fc = new FutureClient();
        Data data = fc.request("请求参赛!");
        System.out.println("请求发送成功!");
        System.out.println("做其他的事情...");

        String result = data.getRequest();
        System.out.println(result);
    }
}
