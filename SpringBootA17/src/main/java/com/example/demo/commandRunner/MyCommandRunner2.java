package com.example.demo.commandRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @ClassName MyCommandRunner2
 * @Author：Mayuan
 * @Date 2023/8/23/0023 10:57
 * @Description TODO
 * @Version 1.0
 **/

@Component
@Order(value = 2)
public class MyCommandRunner2 implements CommandLineRunner {

    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Override
    public void run(String... arg0) throws Exception {
        logger.info("执行启动任务2...");
    }

}
