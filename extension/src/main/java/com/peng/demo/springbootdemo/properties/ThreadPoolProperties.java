package com.peng.demo.springbootdemo.properties;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class ThreadPoolProperties {
    /**
     * 标识每个线程池的唯一名字
     */
    private String poolName;
    private String poolType = "common";

    /**
     * 是否为守护线程
     */
    private boolean isDaemon = false;

    /**
     * 以下都是核心参数
     */
    private int corePoolSize = 1;
    private int maximumPoolSize = 1;
    private long keepAliveTime;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private String queueType = "arrayBlockingQueue";
    private int queueSize = 10;
    private String threadFactoryPrefix = "-td-";
    private String RejectedExecutionHandler;
}