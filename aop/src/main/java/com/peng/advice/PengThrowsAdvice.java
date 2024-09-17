package com.peng.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 12:47
 *
 * 方法抛异常后执行代理逻辑
 *      如何异常类型不匹配则不会执行代理逻辑
 */
public class PengThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) {
        System.out.println("方法抛出异常后执行");
    }
}
