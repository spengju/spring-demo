package com.peng.annotation;

import com.peng.config.WebServerAutoConfiguration;
import com.peng.selector.PengImportSelect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 09:57
 * @Desc:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan
@Configuration
@Import(PengImportSelect.class)
public @interface PengSpringBootApplication {
}
