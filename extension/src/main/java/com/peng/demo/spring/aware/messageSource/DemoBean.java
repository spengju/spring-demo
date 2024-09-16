package com.peng.demo.spring.aware.messageSource;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 16:32
 */
@Component
public class DemoBean implements MessageSourceAware {
    @Override
    public void setMessageSource(MessageSource messageSource) {
        String message = messageSource.getMessage("test", null, new Locale("en_US"));
        System.out.println(message);
    }
}
