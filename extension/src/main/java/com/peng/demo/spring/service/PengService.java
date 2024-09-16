package com.peng.demo.spring.service;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/8 00:55
 */
//@Component
@Data
public class PengService implements BeanNameAware {

    private String beanName;

    private String name = "pj";

    private Integer age;

    public PengService() {
//        System.out.println(beanName + "创建完成!");
    }

    public String getName() {
//        return "spengju";
        System.out.println("getName:" + beanName);
        return this.name;
    }


    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
