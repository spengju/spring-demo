package com.peng.DynamicThreadPool.component;

import com.peng.DynamicThreadPool.properties.ThreadPoolProperties;
import com.peng.DynamicThreadPool.service.DtpRegistry;
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