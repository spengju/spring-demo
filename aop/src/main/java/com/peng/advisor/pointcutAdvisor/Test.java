package com.peng.advisor.pointcutAdvisor;

import com.peng.advisor.DefaultPointcutAdvisorConfig;
import com.peng.service.UserService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:28
 */
public class Test {
    public static void main(String[] args) {
        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(new PengAdvisor());
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
    }
}
