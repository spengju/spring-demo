package com.peng.spring.aware.embeddedValueResolver;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:15
 * <p>
 * 解析表达式 ${} #{}
 */
@Component
public class MyEmbeddedValueResolverAware implements EmbeddedValueResolverAware {
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String json = resolver.resolveStringValue("当前操作系统为:${os.name},表达式 (3*4)的结果:#{3*4}");
        System.out.println(json);

    }
}
