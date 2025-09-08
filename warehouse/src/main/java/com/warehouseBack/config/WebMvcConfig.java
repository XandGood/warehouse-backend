package com.warehouseBack.config;


import com.warehouseBack.interceptor.LoginInterceptor;
import com.warehouseBack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") // 拦截所有接口
                .excludePathPatterns(
                        "/user/login",
                        "/user/add",
                        "/swagger-ui/**",       // Swagger UI页面
                        "/swagger-ui/index.html/**",
                        "/swagger-resources/**", // Swagger资源
                        "/v2/api-docs/**",// Swagger API文档
                        "/v3/api-docs/**",
                        "/webjars/**"           // Swagger UI的JS、CSS等资源
                ); // 放行登录接口（无需Token即可访问）
    }
}
