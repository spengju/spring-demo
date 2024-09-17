package com.peng.proxy;

import com.peng.service.UserInterface;
import com.peng.service.UserService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 12:35
 *
 *  添加代理类或接口:
 *    proxyFactory.setTarget(target);   --> cglib代理
 *    proxyFactory.setInterfaces(UserInterface.class);  --> jdk动态代理
 *
 */
public class SpringProxy {
    public static void main(String[] args) {
        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setInterfaces(UserInterface.class);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("before...");
            }
        });
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
    }
}
