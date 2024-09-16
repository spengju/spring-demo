package com.peng.demo.spring.aware.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:23
 */
@Service
public class UserRegistryService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public boolean registry(User user) {
        System.out.println("[service]用户[" + user + "]注册成功");
        applicationEventPublisher.publishEvent(new EmailEvent(this, user));
        return true;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
