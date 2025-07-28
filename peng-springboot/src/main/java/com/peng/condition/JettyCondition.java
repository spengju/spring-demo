package com.peng.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 10:42
 * @Desc:
 */
public class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //判断有无tomcat依赖
        try {
            context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }
}
