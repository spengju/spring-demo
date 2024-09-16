package com.peng.service;


import com.peng.mapper.OrderMapper;
import com.peng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2023/5/22 22:48
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    public void test() {
        System.out.println(userMapper.selectById());
        System.out.println(orderMapper.selectById());
    }

}
