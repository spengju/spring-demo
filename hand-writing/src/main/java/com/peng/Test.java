package com.peng;

import com.peng.circle.service.UserInterface;
import com.peng.spring.PengApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/7 11:11
 * $description
 */
public class Test {
    public static void main(String[] args) {

        // 扫描--->创建单例Bean BeanDefinition BeanPostPRocess
        PengApplicationContext applicationContext = new PengApplicationContext(AppConfig.class);

        UserInterface userService = (UserInterface) applicationContext.getBean("userService");
        userService.test();
    }
}