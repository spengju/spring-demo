package com.peng.demo.springbootdemo.component;

import com.peng.demo.springbootdemo.service.DtpRegistry;
import org.springframework.context.SmartLifecycle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DtpMonitor implements SmartLifecycle {

    private ScheduledFuture<?> scheduledFuture;

    private boolean isRunning=false;

    private void monitor() {
        for (String name :  DtpRegistry.getAllExecutorNames()) {
            ThreadPoolExecutor dtpExecutor =DtpRegistry.getExecutor(name);
            System.out.println(String.format("线程池名字：%s", name));
            System.out.println(String.format("线程池核心线程数：%s", dtpExecutor.getCorePoolSize()));
            System.out.println(String.format("线程池最大线程数：%s", dtpExecutor.getMaximumPoolSize()));
            System.out.println(String.format("线程池当前线程数：%s", dtpExecutor.getActiveCount()));

        }
    }

    private void alarm() {
        // 读取配置
        int max = 10;

        for (ThreadPoolExecutor threadPoolExecutor : DtpRegistry.getAllDtpExecutor()) {
            int activeCount = threadPoolExecutor.getActiveCount();
            if (activeCount >= max) {
                System.out.println(String.format("告警，当前线程池的线程个数为%s, 告警阈值为%s", activeCount, max));
            }
        }
    }

    @Override
    public void start() {
         scheduledFuture = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            monitor();
            alarm();
        }, 5, 5, TimeUnit.SECONDS);
        isRunning=true;
    }

    @Override
    public void stop() {
        scheduledFuture.cancel(false);
        isRunning=false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
