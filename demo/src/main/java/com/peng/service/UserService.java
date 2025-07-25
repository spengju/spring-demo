package com.peng.service;

import com.peng.mini.spring.*;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/22 16:08
 * @Desc:
 */
@Component("userService")
//@Scope("prototype")
public class UserService implements InitializingBean ,BeanNameAware,ApplicationContextAware {

    private ApplicationContext applicationContext;

//    @Autowired
    private OrderService orderService;

    private String name;

    public void test() {
//        System.out.println(orderService);
//        System.out.println(applicationContext);
//        System.out.println(applicationContext.getBean("orderService"));
        System.out.println("hello peng");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @PostConstruct
    public void a(){
        System.out.println("PostConstruct...");
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
