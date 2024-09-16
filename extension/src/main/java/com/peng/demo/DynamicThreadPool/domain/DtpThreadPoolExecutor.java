package com.peng.demo.DynamicThreadPool.domain;


import com.peng.demo.DynamicThreadPool.properties.ThreadPoolProperties;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

// 单独声明动态线程池类
// 把动态线程池和 内置线程池区分开  方便从容器中获取
public class DtpThreadPoolExecutor extends ThreadPoolExecutor{

    public DtpThreadPoolExecutor(ThreadPoolProperties properties) {
        super(
                properties.getCorePoolSize(),
                properties.getMaximumPoolSize(),
                properties.getKeepAliveTime(),
                properties.getTimeUnit(),
                // 这里的参数我随意写一下， 实际中可以根据配置动态创建
                new ArrayBlockingQueue<>(properties.getQueueSize())
        );
    }

}
