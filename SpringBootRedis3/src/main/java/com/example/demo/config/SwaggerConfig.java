package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

/**
 * @ClassName SwaggerConfig
 * @Author：Mayuan
 * @Date 2023/9/5/0005 16:24
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                // 扫描哪个接口的包
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("接口文档")
                        .description("详细信息: SpringBoot+Mybatis+Redis 接口文档生成")
                        // 版本信息
                        .version("1.1")
                        // 开发文档的联系人
                        .contact(new Contact("马德宝","https://gitee.com/","2901429479@qq.com"))
                        .license("This Baidu License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }

}
