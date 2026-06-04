package com.example.aop;


import com.example.aop.config.AopConfig;
import com.example.aop.service.OrderService;
import com.example.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);

        System.out.println("========== 测试1：带注解的方法（环绕通知+前置+后置+最终） ==========");
        String user = userService.findUserById(100L);
        System.out.println("最终结果: " + user);

        System.out.println("\n========== 测试2：不带注解的方法（只有前置+后置+最终） ==========");
        userService.createUser("李四");

        System.out.println("\n========== 测试3：异常场景 ==========");
        try {
            userService.deleteUser(null);
        } catch (Exception e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }

        System.out.println("\n========== 测试4：另一个服务类 ==========");
        String order = orderService.createOrder("iPhone", 2);
        System.out.println("最终结果: " + order);
    }
}