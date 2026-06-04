package com.mayuan.www;

/**
 * @ClassName ColorSelector
 * @Author：Mayuan
 * @Date 2023/8/10/0010 17:03
 * @Description TODO
 * @Version 1.0
 **/
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ColorSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 这里可以通过AnnotationMetadata处理业务逻辑，为了演示我们就尽量简单着来了
        return new String[]{Red.class.getName(), Blue.class.getName(), Yellow.class.getName()};
    }

}