package com.peng.demo.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:03
 */
@Component
public class Peng8BeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8." + beanName + "初始化之后,bean已经是完整bean");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
