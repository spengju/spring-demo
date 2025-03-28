package com.peng;

import com.peng.mini.spring.PengApplicationContext;
import com.peng.service.UserService;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/21 23:32
 * @Desc: $description
 * jfr
 * --add-opens java.base/java.lang=ALL-UNNAMED -XX:StartFlightRecording
 */
public class Main {
    public static void main(String[] args) {
        PengApplicationContext context=new PengApplicationContext(MyConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
//        System.out.println(userService.getName());
    }
}