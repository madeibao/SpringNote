package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

/**
 * @ClassName MyScheduleConfig
 * @Author：Mayuan
 * @Date 2023/8/17/0017 9:04
 * @Description TODO
 * @Version 1.0
 **/


/**
 * @author ASUS
 * @Configuration
 * @EnableScheduling
 */

public class MyScheduleConfig {

    //spring boot 实现任务调度非常简单，只需要在调度类头上添加@Configuration，然后再调度方法上添加
    //@Schuldle 注解，并为@Schuldle 指定 CronExpress 表达式。
    private Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Scheduled(cron = " 0 0/1 ****?")//定义任务调度器
    public void job1(){
        logger.info("this is my first job execute");
    }

}
