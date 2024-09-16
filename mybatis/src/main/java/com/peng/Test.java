package com.peng;



import com.peng.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Author: spengju
 * @Date: 2023/5/22 16:14
 */
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);



        context.refresh();

        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
