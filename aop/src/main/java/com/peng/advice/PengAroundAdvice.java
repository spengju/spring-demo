package com.peng.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 12:46
 *
 *  invocation.proceed();
 *      1.执行被代理的方法
 *      2.会递归执行proxyFactory.addAdvice代理的逻辑
 *
 */
@Component
public class PengAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("方法执行Around前");
        Object proceed = invocation.proceed();
        System.out.println("方法执行Around后");
        return proceed;
    }
}
