package com.peng;

import com.peng.server.WebServer;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/25 15:26
 * @Desc: $description
 */

public class PengMyApplication {

    public static void run(Class configClass, String[] args) {
        //创建spring容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(configClass);
        context.refresh();


        //启动tomcat jetty
//        startTomcat(context);
        WebServer webServer = getWebServer(context);
        webServer.start();
    }

    private static WebServer getWebServer(AnnotationConfigWebApplicationContext applicationContext) {

        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);

        if (beansOfType.isEmpty()) {
            throw new NullPointerException();
        }

        if (beansOfType.size() > 1) {
            throw new IllegalStateException();
        }

        return beansOfType.values().stream().findFirst().get();
    }

//    private static void startTomcat(AnnotationConfigWebApplicationContext webApplicationContext) {
//        Tomcat tomcat = new Tomcat();
//
//        Server server = tomcat.getServer();
//        Service service = server.findService("Tomcat");
//
//        Connector connector = new Connector();
//        connector.setPort(8081);
//
//        Engine engine = new StandardEngine();
//        engine.setDefaultHost("localhost");
//
//        Host host = new StandardHost();
//        host.setName("localhost");
//
//        String contextPath = "";
//        Context context = new StandardContext();
//        context.setPath(contextPath);
//        context.addLifecycleListener(new Tomcat.FixContextListener());
//
//        host.addChild(context);
//        engine.addChild(host);
//
//        service.setContainer(engine);
//        service.addConnector(connector);
//
//        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(webApplicationContext));
//        context.addServletMappingDecoded("/*", "dispatcher");
//
//        try {
//            tomcat.start();
//        } catch (LifecycleException e) {
//            e.printStackTrace();
//        }
//    }
}