package com.peng.spring.created;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 17:02
 */
//@ComponentScan
//@Configuration
@SpringBootApplication
public class MainStart {
    public static void main(String[] args) {
        SpringApplication.run(MainStart.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainStart.class);
//        context.close();
    }
}
