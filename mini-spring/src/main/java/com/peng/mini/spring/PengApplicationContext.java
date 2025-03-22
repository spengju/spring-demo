package com.peng.mini.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/22 16:05
 * @Desc:
 */
public class PengApplicationContext {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private final Map<String, Object> singletonObjects = new HashMap<>();

    public PengApplicationContext(Class configClass) {
        scan(configClass);
    }

    private void scan(Class configClass) {
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);

            String path = componentScan.value();
            path = path.replace(".", "/");
            ClassLoader classLoader = configClass.getClassLoader();
            URL resource = classLoader.getResource(path);

            File file = null;
            try {
                file = new File(Objects.requireNonNull(resource).toURI());
                if (file.isDirectory()) {
                    for (File listFile : Objects.requireNonNull(file.listFiles())) {
                        String filePath = listFile.getPath();
                        System.out.println(filePath);
                        filePath = filePath.substring(filePath.indexOf("com"), filePath.lastIndexOf(".class"));
                        String classPath = filePath.replace("/", ".");
                        Class<?> clazz = classLoader.loadClass(classPath);
                        System.out.println(clazz);

                        if (clazz.isAnnotationPresent(Component.class)) {
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setBeanClass(clazz);
                            Component componentAnnotation = clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            if (beanName.isEmpty()) {
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            }

                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinition.setLazy(false);
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    }
                }

            } catch (URISyntaxException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new RuntimeException("beanName不存在");
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition.getScope().equals("singleton")) {
            Object singletonBean = singletonObjects.get(beanName);
            if (singletonBean == null) {
                singletonBean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, singletonBean);
            }
            return singletonBean;
        } else {
            return createBean(beanName, beanDefinition);
        }
    }

    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Object instance = beanClass.getConstructor().newInstance();
            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
