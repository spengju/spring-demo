package com.peng.demo.springbootdemo.component;

import com.peng.demo.springbootdemo.properties.ThreadPoolProperties;
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