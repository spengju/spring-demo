package com.peng.advisor;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:27
 */
@ComponentScan("com.peng")
public class BeanNameAutoProxyConfig {

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        //bean的名字符合下面名字都会产生代理对象
        beanNameAutoProxyCreator.setBeanNames("userSer*");
        beanNameAutoProxyCreator.setInterceptorNames("pengAroundAdvice");
        beanNameAutoProxyCreator.setProxyTargetClass(true);

        return beanNameAutoProxyCreator;
    }
}
