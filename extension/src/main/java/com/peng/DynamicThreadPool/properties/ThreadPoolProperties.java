package com.peng.DynamicThreadPool.properties;

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

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getPoolType() {
        return poolType;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    public boolean isDaemon() {
        return isDaemon;
    }

    public void setDaemon(boolean daemon) {
        isDaemon = daemon;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public String getThreadFactoryPrefix() {
        return threadFactoryPrefix;
    }

    public void setThreadFactoryPrefix(String threadFactoryPrefix) {
        this.threadFactoryPrefix = threadFactoryPrefix;
    }

    public String getRejectedExecutionHandler() {
        return RejectedExecutionHandler;
    }

    public void setRejectedExecutionHandler(String rejectedExecutionHandler) {
        RejectedExecutionHandler = rejectedExecutionHandler;
    }
}