package com.peng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 09:52
 * @Desc:
 */
@RestController
public class PengController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
