package com.peng.spring.created.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:51
 */
@Component
public class ContextRefreshedListener {

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(){
        System.out.println("--------------\n容器加载完毕\n--------");
    }
}
