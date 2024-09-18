package com.peng.service;

import com.peng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

    public void testInsert() {
//        jdbcTemplate.execute("insert into user values ('peng',25,'2658111307@qq.com')");
        String sql = "INSERT INTO user (name, age, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, "peng", 25, "2658111307@qq.com");
        System.out.println("Insert successful");
    }

    public void testQuery() {
        String sql = "SELECT * FROM user";

        // 使用 BeanPropertyRowMapper 自动映射结果
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }
}
