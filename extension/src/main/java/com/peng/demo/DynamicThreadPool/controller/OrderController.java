package com.peng.demo.DynamicThreadPool.controller;

import com.peng.demo.DynamicThreadPool.domain.DtpThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("/add")
    public String addOrder(){

        // 创建ThreadPoolExecutor对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                20,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );

        executor.execute(() -> {
            System.out.println("下单...");
        });
        return "success!";
    }

    @Autowired
    private DtpThreadPoolExecutor dtpExecutor1;

    @GetMapping("/add2")
    public String addOrder2(){

        dtpExecutor1.execute(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("下单...");
        });
        return "success!";
    }
}

