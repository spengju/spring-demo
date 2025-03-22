package com.peng;

import com.peng.mini.spring.PengApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/21 23:32
 * @Desc: $description
 */
public class Main {
    public static void main(String[] args) {
        PengApplicationContext context=new PengApplicationContext(MyConfig.class);
        System.out.println(context.getBean("userService"));
        System.out.println(context.getBean("userService"));
        System.out.println(context.getBean("userService"));
    }
}