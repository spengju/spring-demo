package com.peng.demo.DynamicThreadPool;

import com.peng.demo.DynamicThreadPool.annotation.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamicThreadPool
public class DynamicThreadpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicThreadpoolApplication.class, args);
	}


}
