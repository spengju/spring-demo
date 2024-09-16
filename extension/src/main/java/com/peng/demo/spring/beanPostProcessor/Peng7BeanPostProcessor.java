package com.peng.demo.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:02
 */
@Component
public class Peng7BeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("7." + beanName + "初始化之前");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
