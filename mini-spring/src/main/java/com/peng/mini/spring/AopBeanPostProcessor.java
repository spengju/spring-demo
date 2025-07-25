package com.peng.mini.spring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/24 13:57
 * @Desc:
 */
//@Component
public class AopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        //cglib动态代理 父子类 代理类继承需要代理的类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("切面逻辑 before...");
                Object result = method.invoke(bean, objects);
                System.out.println("切面逻辑 after...");
                return result;
            }
        });
        System.out.println("22222222");
        return enhancer.create();
    }
}
