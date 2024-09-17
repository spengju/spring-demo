package com.peng.proxy;

import com.peng.service.UserService;
import com.peng.service.UserInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 12:26
 *
 * 局限性:只能代理接口
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        UserService target = new UserService();
        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(), new Class[]{UserInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                target.test();
                System.out.println("after...");
                return null;
            }
        });
        userInterface.test();

    }
}
