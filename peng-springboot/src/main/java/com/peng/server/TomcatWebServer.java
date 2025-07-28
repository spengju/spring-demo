package com.peng.server;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 10:32
 * @Desc:
 */
public class TomcatWebServer implements WebServer {
    @Override
    public void start() {
        System.out.println("TomcatWebServer start...");
    }

    @Override
    public void stop() {

    }
}
