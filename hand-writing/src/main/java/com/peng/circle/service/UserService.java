package com.peng.circle.service;


import com.peng.spring.Autowired;
import com.peng.spring.BeanNameAware;
import com.peng.spring.Component;

/**
 * @author peng
 */
@Component
public class UserService implements UserInterface, BeanNameAware {

    @Autowired
    private OrderService orderService;

    @PengValue("xxx")
    private String test;


    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void test() {
        System.out.println(beanName);
    }
}
