package com.peng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/11/18 18:44
 * @Desc:
 */
@RestController
@RequestMapping("/test")
public class MyController {
    @RequestMapping("/test")
    public String getName(Map<String, Object> map) {
        System.out.println(map);
        return "hello";
    }
}
