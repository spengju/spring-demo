package com.peng.spring.aware.event;

import org.springframework.context.ApplicationEvent;


/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:21
 */
public class EmailEvent extends ApplicationEvent {
    private User user;

    public EmailEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
