package com.peng.mini.spring;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/24 13:54
 * @Desc:
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName){
        return bean;
    }
}
