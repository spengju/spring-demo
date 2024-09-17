package com.peng.advisor;

import com.peng.advice.PengBeforeAdvice;
import com.peng.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 16:18
 */
public class TestAdvisor {
    public static void main(String[] args) {

        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            /**
             *  匹配
             * @return
             */
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("test");
                    }
                };
            }

            /**
             * 代理逻辑
             * @return
             */
            @Override
            public Advice getAdvice() {
                return new PengBeforeAdvice();
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.test();
    }
}
