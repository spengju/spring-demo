package com.peng.spring.created;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:52
 *
 * 1.有别于初始化回调，会在所有单例bean创建完后调用
 * 2.有别于refreshedEvent,依赖小
 * 3.beanFactory也有完成调用的拓展点
 *
 */
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {

    /**
     * 可以拿到所有bean统一做初始化逻辑
     */
    @Override
    public void afterSingletonsInstantiated() {

        System.out.println("所有bean创建完后调用");
    }
}
