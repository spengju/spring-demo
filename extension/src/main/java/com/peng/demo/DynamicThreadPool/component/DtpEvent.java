package com.peng.demo.DynamicThreadPool.component;

import com.peng.demo.DynamicThreadPool.properties.ThreadPoolProperties;
import org.springframework.context.ApplicationEvent;

/***
 * 事件
 */
public class DtpEvent  extends ApplicationEvent {

    private ThreadPoolProperties properties;

    public DtpEvent(ThreadPoolProperties properties) {
        super(properties);
        this.properties = properties;
    }

    public ThreadPoolProperties getProperties() {
        return properties;
    }
}