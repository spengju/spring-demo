package com.peng.service;

import com.peng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/18 09:55
 */
@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;
    @Transactional
    public void testInsert() {
        String sql = "INSERT INTO user (name, age, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, "peng", 25, "2658111307@qq.com");
        /**
         * 得是这样调用,传播机制才能生效  --> 代理类去执行方法
         */
        userService.testQuery();
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
        System.out.println("Insert successful");
    }
    @Transactional(propagation = Propagation.NESTED)
    public void testQuery() {
        String sql = "SELECT * FROM user";

        // 使用 BeanPropertyRowMapper 自动映射结果
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
        System.out.println(users);
    }
}
