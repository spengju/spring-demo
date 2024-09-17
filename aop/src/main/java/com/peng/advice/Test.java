package com.peng.advice;

import com.peng.service.UserService;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 12:48
 */
public class Test {
    public static void main(String[] args) {

        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new PengBeforeAdvice());
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
    }
}
