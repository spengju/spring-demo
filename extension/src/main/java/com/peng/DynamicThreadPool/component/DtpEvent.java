package com.peng.DynamicThreadPool.component;

import com.peng.DynamicThreadPool.properties.ThreadPoolProperties;
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