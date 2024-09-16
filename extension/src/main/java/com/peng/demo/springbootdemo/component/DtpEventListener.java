package com.peng.demo.springbootdemo.component;

import com.peng.demo.springbootdemo.properties.ThreadPoolProperties;
import com.peng.demo.springbootdemo.service.DtpRegistry;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DtpEventListener {//}  implements ApplicationListener<OrderEvent> {

    // 基于注解的
    @EventListener(DtpEvent.class)
    public void onApplicationEvent(DtpEvent event) {
        ThreadPoolProperties properties = event.getProperties();
        DtpRegistry.refresh(properties.getPoolName(),properties);
    }

}