package com.github.mimiknight.panda.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring拦截器注册配置类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Configuration
public class InterceptorRegistryConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
