package com.github.mimiknight.panda.common.config;

import com.github.mimiknight.panda.common.constant.Constant;
import com.github.mimiknight.panda.common.spring.filter.LogTraceFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * Spring过滤器注册配置类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-07-31 21:09:19
 */
@Configuration
public class FilterRegistryConfig {

    /**
     * 全路径匹配URL规则
     *
     * @return {@link List}<{@link String}>
     */
    private List<String> fullApiPathMatchPattern() {
        return Collections.singletonList(Constant.Filter.FULL_API_PATH_MATCH_PATTERN);
    }

    @Bean
    public FilterRegistrationBean<LogTraceFilter> registerLogTraceFilter() {
        FilterRegistrationBean<LogTraceFilter> registrationBean = new FilterRegistrationBean<>();
        // 设置过滤器名称
        registrationBean.setName(LogTraceFilter.class.getSimpleName());
        // 注入过滤器
        registrationBean.setFilter(new LogTraceFilter());
        // 过滤器顺序
        registrationBean.setOrder(500);
        // 拦截规则
        registrationBean.setUrlPatterns(fullApiPathMatchPattern());
        return registrationBean;
    }


}
