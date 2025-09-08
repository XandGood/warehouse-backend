package com.warehouseBack.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 注解作用在方法上
@Target(ElementType.METHOD)
// 运行时生效
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireRole {
    // 允许访问的角色（默认值为管理员）
    String value() default "ADMIN";
}
