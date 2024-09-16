package com.peng.demo.spring.created.event;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 17:10
 *
 * 需要调用 context.start();方法才会发布ContextStartedEvent事件
 */
@Component
public class ContextStartedListener {
    @EventListener(ContextStartedEvent.class)
    public void onApplicationEvent(){
        System.out.println("--------------\n容器启动完毕\n--------");
    }
}
