package com.peng.demo.spring.aware.event;

import org.springframework.context.ApplicationListener;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:21
 */
public class EventListener implements ApplicationListener<EmailEvent> {
    @Override
    public void onApplicationEvent(EmailEvent event) {
        //执行发送邮件代码
        System.out.println("正在发送邮件至:    " + event.getUser().getEmail());
        //执行发送短信代码
        System.out.println("正在发送短信至:    " + event.getUser().getPhoneNumber());
    }
}
