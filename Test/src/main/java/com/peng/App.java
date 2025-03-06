package com.peng;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
@SpringBootApplication
@Slf4j
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Hello World!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        log.info("new configure Application start up......");
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    log.info("-----------222222-----------");
                    log.info("-----------222222-----------");
                    log.info("------------22222----------");
                    log.info("------------222222----------");
                    log.info("{}-start2222...", Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(30);
                    log.info("{}-starting22222...", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        return builder.sources(this.getClass());
    }
}
