package com.peng.demo.spring;

import com.peng.demo.spring.beanDefinition.MyBenDefinition;
import com.peng.demo.spring.beanDefinition.MyImportBeanDefinitionRegistry;
import com.peng.demo.spring.beanDefinition.MyImportSelector;
import com.peng.demo.spring.service.PengService;
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
