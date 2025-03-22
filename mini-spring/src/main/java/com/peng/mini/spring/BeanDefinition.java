package com.peng.mini.spring;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/22 16:24
 * @Desc:
 */
public class BeanDefinition {

    private Class beanClass;
    private String scope;
    private Boolean isLazy;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Boolean getLazy() {
        return isLazy;
    }

    public void setLazy(Boolean lazy) {
        isLazy = lazy;
    }
}
