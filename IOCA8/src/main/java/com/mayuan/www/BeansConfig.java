package com.mayuan.www;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName BeansConfig
 * @Author：Mayuan
 * @Date 2023/8/10/0010 17:01
 * @Description TODO
 * @Version 1.0
 **/

//@Import({Red.class, Yellow.class, Blue.class})

//@Import(ColorSelector.class)

@Import(ColorRegistrar.class)
@Configuration
public class BeansConfig {

}

