package com.example.spi;

import java.util.ServiceLoader;

/**
 *
 * @ClassName DemoUsage
 * @Author Mayuan
 * @Date 2026/8/9/星期日 14:57
 * @Version 1.0
 **/
public class DemoUsage {
    public static void main(String[] args) {
        ServiceLoader<MyService> loader = ServiceLoader.load(MyService.class);
        for (MyService service : loader) {
            service.execute();
        }
    }
}
