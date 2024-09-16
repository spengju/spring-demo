package com.peng.circle.service;


import com.peng.spring.BeanPostProcessor;
import com.peng.spring.Component;

import java.lang.reflect.Field;

/**
 * @author peng
 */
@Component
public class PengValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(PengValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, field.getAnnotation(PengValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // bean
        return bean;
    }
}
