package com.peng.spring.created;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:57
 *
 *
 *  控制一个组建的生命周期,比如定时任务组建\资源预热\缓存预热
 *  容器启动完:  定时任务启动
 *  容器关闭:    定时任务停止
 *
 *  和Lifecycle区别：
 *      SmartLifecycle会自动调用
 *      Lifecycle需要手动自动启动和停止才会调用
 */
@Component
public class MySmartLifecycle implements SmartLifecycle {
    boolean isRunning;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("容器加载完,组建启动");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("容器关闭，组建停止");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        return SmartLifecycle.super.isAutoStartup();
    }
}
