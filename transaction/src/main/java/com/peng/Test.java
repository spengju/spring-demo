package com.peng;

import com.peng.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/18 10:09
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.testInsert();
    }
}
