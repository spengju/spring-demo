package com.peng.service;

import com.peng.mini.spring.BeanPostProcessor;
import com.peng.mini.spring.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/24 15:50
 * @Desc:
 */
@Component
public class PengBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("PengBeanPostProcessor...");
        return bean;
    }
}
