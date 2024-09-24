package com.peng.DynamicThreadPool.component;

import com.peng.DynamicThreadPool.properties.DtpProperties;
import com.peng.DynamicThreadPool.properties.ThreadPoolProperties;
import com.peng.DynamicThreadPool.domain.DtpThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;
import java.util.Objects;

@Slf4j
public class DtpBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //绑定资源
        BindResult<DtpProperties> bindResult = Binder.get(environment).bind("spring.dtp", DtpProperties.class);
        DtpProperties dtpProperties = bindResult.get();

        List<ThreadPoolProperties> executors = dtpProperties.getExecutors();
        if (Objects.isNull(executors)) {
            log.info("未检测本地到配置文件线程池");
            return;
        }

        // 把动态线程池对象交给Spring管理
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DtpThreadPoolExecutor.class);
        for (ThreadPoolProperties properties : executors) {

            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0,properties);
            registry.registerBeanDefinition(properties.getPoolName(), beanDefinition);
        }

    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

