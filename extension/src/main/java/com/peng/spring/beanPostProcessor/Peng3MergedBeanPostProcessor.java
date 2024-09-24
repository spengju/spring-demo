package com.peng.spring.beanPostProcessor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 15:24
 */
@Component
public class Peng3MergedBeanPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> aClass, String beanName) {
//        beanDefinition.getPropertyValues().add("aaa","xxx");
        System.out.println("3."+beanName+"实例化后..为属性注入做准备，可以给BeanDefinition指定注入的值 ");
    }

    @Override
    public void resetBeanDefinition(String beanName) {
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
