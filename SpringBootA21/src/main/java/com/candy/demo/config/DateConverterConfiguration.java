package com.candy.demo.config;

import com.candy.demo.myconverter.DateTypeRegConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * @ClassName DateConverterConfiguration
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:29
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class DateConverterConfiguration {
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * 注册加载自定义转换器
     */
    @PostConstruct
    public void addCoverters() {
        // 获取绑定器对象
        ConfigurableWebBindingInitializer configurableWebBindingInitializer =
                (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        // 加入自定义转换器
        if (configurableWebBindingInitializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) configurableWebBindingInitializer.getConversionService();
            // 此处可以添加自定义类型转换器
            genericConversionService.addConverter(new DateTypeRegConverter());
            // 继续添加转换器
        }
    }
}
