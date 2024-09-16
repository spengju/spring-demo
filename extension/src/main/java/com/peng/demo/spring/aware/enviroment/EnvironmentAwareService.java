package com.peng.demo.spring.aware.enviroment;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:19
 *
 * 处理和获取环境变量，包括@PoropertySource指定的配置文件解析
 *
 * 或者获取springboot中配置文件的值
 */
public class EnvironmentAwareService implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        String property = environment.getProperty("peng.name", String.class);
        System.out.println(property);
    }
}
