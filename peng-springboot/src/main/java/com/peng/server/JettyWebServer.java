package com.peng.server;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 10:33
 * @Desc:
 */
public class JettyWebServer implements WebServer {
    @Override
    public void start() {
        System.out.println("JettyWebServer start...");
    }

    @Override
    public void stop() {

    }
}
