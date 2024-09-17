package com.peng.advisor;

import com.peng.advice.PengAroundAdvice;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:41
 * DefaultAdvisorAutoProxyCreator是一个BeanPostProcessor
 *      初始化后会将所有Advisor的bean找出来
 *      然后找bean里面有没有方法名字叫 pointcut.addMethodName("test");
 *          有就需要动态代理
 */
@ComponentScan("com.peng")
@Import(DefaultAdvisorAutoProxyCreator.class)
public class DefaultPointcutAdvisorConfig {

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("test");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(new PengAroundAdvice());
        return defaultPointcutAdvisor;
    }

    /**
     *
     * @return
     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//
//        return defaultAdvisorAutoProxyCreator;
//    }
}
