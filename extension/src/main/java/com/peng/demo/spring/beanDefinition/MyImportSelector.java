package com.peng.demo.spring.beanDefinition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 12:35
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 会将返回的类注册成BeanDefinition
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.peng.demo.spring.service.PengService"
        };
    }
}
