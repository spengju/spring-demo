package com.peng.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/28 11:06
 * @Desc:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(PengCondition.class)
public @interface PengConditionalOnClass {
    String value();
}
