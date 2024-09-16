package com.peng.demo.DynamicThreadPool.properties;

import lombok.Data;

import java.util.List;

@Data
public class DtpProperties {

    private List<ThreadPoolProperties> executors;
}