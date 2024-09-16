package com.peng.demo.spring.beanDefinition;

import com.peng.demo.spring.aware.event.User;
import com.peng.demo.spring.service.PengService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 12:45
 */
public class MyImportBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(PengService.class);
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.getPropertyValues().add("name","spengju");
        beanDefinition.getPropertyValues().add("age",25);

//        beanDefinition.setLazyInit(true);
//        beanDefinition.setScope();
//        beanDefinition.setInitMethodName();

        /**
         * 可以获取当前@Import注解所在类的所有注解信息
         */
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
        System.out.println(annotationAttributes);

        /**
         * 动态设置构造函数
         */
//        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, User.class);

        registry.registerBeanDefinition("pengService",beanDefinition);
    }
}
