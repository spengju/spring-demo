package com.peng.advisor;

import com.peng.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:28
 */
public class Test {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyFactoryBeanConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DefaultPointcutAdvisorConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
