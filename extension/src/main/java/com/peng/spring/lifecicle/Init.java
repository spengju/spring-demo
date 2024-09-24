package com.peng.spring.lifecicle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:44
 *
 * 初始化回调,执行顺序：
 *  1.@PostConstruct
 *  2.InitializingBean
 *  3.init-method
 */
public class Init implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
    @PostConstruct
    public void afterPropertiesSet2(){

    }
//    @Bean(initMethod = "afterPropertiesSet3")
    public void afterPropertiesSet3() {

    }


}
