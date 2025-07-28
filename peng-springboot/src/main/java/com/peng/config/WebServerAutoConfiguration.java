package com.peng.config;

import com.peng.condition.JettyCondition;
import com.peng.condition.PengConditionalOnClass;
import com.peng.condition.TomcatCondition;
import com.peng.server.JettyWebServer;
import com.peng.server.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 10:40
 * @Desc:
 */
@Configuration
public class WebServerAutoConfiguration {

    @Bean
//    @Conditional(TomcatCondition.class)
    @PengConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer() {
        return new TomcatWebServer();
    }

    @Bean
//    @Conditional(JettyCondition.class)
    @PengConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }


}
