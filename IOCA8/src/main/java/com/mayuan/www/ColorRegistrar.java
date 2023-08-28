package com.mayuan.www;

/**
 * @ClassName ColorRegistrar
 * @Author：Mayuan
 * @Date 2023/8/10/0010 17:04
 * @Description TODO
 * @Version 1.0
 **/
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ColorRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 如果red没有注入，则手动注入
        if(!registry.containsBeanDefinition(Red.class.getName())){
            RootBeanDefinition red = new RootBeanDefinition(Red.class);
            registry.registerBeanDefinition("red",red);
        }
        // 如果blue没有注入，则手动注入
        if(!registry.containsBeanDefinition(Blue.class.getName())){
            RootBeanDefinition blue = new RootBeanDefinition(Blue.class);
            registry.registerBeanDefinition("blue",blue);
        }
        // 如果yellow没有注入，则手动注入
        if(!registry.containsBeanDefinition(Yellow.class.getName())){
            RootBeanDefinition yellow = new RootBeanDefinition(Yellow.class);
            registry.registerBeanDefinition("yellow",yellow);
        }
    }

}