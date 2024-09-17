package com.peng.advisor.pointcutAdvisor;

import com.peng.advice.PengBeforeAdvice;
import com.peng.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 23:04
 */
//@Component
public class PengAdvisor implements PointcutAdvisor {
    @Override
    public Advice getAdvice() {
        return new PengBeforeAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> clazz) {
                        return clazz.equals(UserService.class);
                    }
                };
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("test");
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object... args) {
                        return method.getName().equals("test");
                    }
                };
            }
        };
    }
}
