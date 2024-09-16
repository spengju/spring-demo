package com.peng.mybatis.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/9/16 21:16
 */
//@Component
public class PengFactoryBean implements FactoryBean {
    private Class mapperInterface;

    private SqlSession sqlSession;


    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    public PengFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
//        Object proxyInstance = Proxy.newProxyInstance(PengFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName());
//                return null;
//            }
//        });
//        return proxyInstance;
        return sqlSession.getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }


}
