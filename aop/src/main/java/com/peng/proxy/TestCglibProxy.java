package com.peng.proxy;

import com.peng.service.UserService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/17 10:59
 * $description
 * <p>
 * 标准反射的开销更大,代理去执行更高效
 */
public class TestCglibProxy {


    public static void main(String[] args) {
        UserService target = new UserService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{
                new MethodInterceptor() {
                    /**
                     *  被代理方法
                     *  o   --> 由CGLIB 生成的代理对象。所有对 UserService 方法的调用首先会通过这个代理对象进行拦截
                     *  method  --> java.lang.reflect.Method 对象,被调用的方法
                     *  objects --> 调用方法时传入的所有参数
                     *  methodProxy --> CGLIB 提供的 MethodProxy 对象，用于高效地调用被拦截的方法
                     *  target  --> 被代理对象(usersService)
                     *
                     *  methodProxy.invokeSuper(o, objects);    --> MethodProxy 对象在代理对象的父类（即原始类）上调用被拦截的方法
                     *
                     *  NoOp.INSTANCE:  --> 啥也不做
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("before...");

                        Object result = methodProxy.invoke(target, objects);
                        /**
                         * 反射执行,结果一样
                         */
//                        Object result = method.invoke(target, objects);
                        /**
                         *  MethodProxy 对象在代理对象的父类（即原始类）上调用被拦截的方法
                         */
//                        methodProxy.invokeSuper(o, objects);
                        System.out.println("after...");
                        return result;
                    }
                }
                , NoOp.INSTANCE});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                /**
                 *  返回对应需要执行的代理逻辑的下标
                 */
                if (method.equals("test")) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        UserService userService = (UserService) enhancer.create();
//        userService.test();
        userService.test2();
    }
}