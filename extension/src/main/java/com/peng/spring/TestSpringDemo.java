package com.peng.spring;

import com.peng.spring.service.PengService;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

import java.beans.Introspector;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 11:03
 * $description
 */
public class TestSpringDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(TestSpringDemo.class);

        //获取
        AnnotatedGenericBeanDefinition beanDefinition = (AnnotatedGenericBeanDefinition) beanFactory.getBeanDefinition("testSpringDemo");
        AnnotationMetadata metadata = beanDefinition.getMetadata();
//        beanDefinition.setInstanceSupplier(new Supplier<PengService>() {
//            @Override
//            public PengService get() {
//                return new PengService();
//            }
//        });
//        if (metadata.hasAnnotatedMethods(ComponentScan.class.getName())){
//            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ComponentScan.class.getName());
//            //为空会将当前配置类所在路径当作扫描包
//            Object o = annotationAttributes.get("basePackages");
//        }

        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("com.peng.demo.spring.service");
        //实例化所有单例bean
//        beanFactory.preInstantiateSingletons();

        PengService bean = (PengService) beanFactory.getBean(Introspector.decapitalize(PengService.class.getSimpleName()));
        System.out.println(bean.getName());
    }
}