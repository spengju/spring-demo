package com.peng.advisor;

import com.peng.advice.PengBeforeAdvice;
import com.peng.service.UserService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:27
 */
@ComponentScan("com.peng")
public class ProxyFactoryBeanConfig {
    @Bean
    public ProxyFactoryBean userService() {
        UserService userService = new UserService();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.addAdvice(new PengBeforeAdvice());
        proxyFactoryBean.setTarget(userService);

        return proxyFactoryBean;
    }

}
