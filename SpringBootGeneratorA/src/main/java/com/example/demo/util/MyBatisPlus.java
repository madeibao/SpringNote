package com.example.demo.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @ClassName MyBatisPlus
 * @Author：Mayuan
 * @Date 2023/9/19/0019 10:14
 * @Description TODO
 * @Version 1.0
 **/
public class MyBatisPlus {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/aspace2?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        String username="root";
        String password="123456";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("mayuan") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("E:\\JavaWorkSpace2\\SpringBootGeneratorA\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.demo") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\JavaWorkSpace2\\SpringBootGeneratorA\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); //启动lombok
                    builder.mapperBuilder().enableMapperAnnotation().build(); //启用@mapper注释
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle(); //启用驼峰转连字符样式
                    builder.addInclude("user"); // 设置需要生成的表名
                })
                .execute();
    }
}
