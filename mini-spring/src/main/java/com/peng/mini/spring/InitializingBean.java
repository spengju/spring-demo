package com.peng.mini.spring;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/23 14:34
 * @Desc:
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
