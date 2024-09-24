package com.peng.spring;

import com.peng.spring.beanDefinition.MyImportBeanDefinitionRegistry;
import com.peng.spring.service.PengService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 11:38
 */
//@Import(MyBenDefinition.class)
//@Import(MyImportSelector.class)
@ComponentScan
@Import(MyImportBeanDefinitionRegistry.class)
public class BeanRegistryDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanRegistryDemo.class);
        System.out.println(context.getBeansOfType(PengService.class));
//        System.out.println(bean.getName());
    }
}
