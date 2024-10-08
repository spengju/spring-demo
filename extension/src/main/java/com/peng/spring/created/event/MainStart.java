package com.peng.spring.created.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 17:02
 */
@ComponentScan
@Configuration
//@SpringBootApplication
public class MainStart {
    public static void main(String[] args) {
//        SpringApplication.run(MainStart.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainStart.class);
        context.start();
//        context.close();
    }
}
