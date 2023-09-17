package com.github.mimiknight.panda.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Spring监听器配置指定线程 异步执行
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-18 00:07:11
 */
@Configuration
public class ApplicationEventAsyncConfig {

    @Autowired
    @Qualifier(value = "MyThreadPoolExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        // 创建一个事件广播器
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        // 设置异步执行器,来完成异步执行监听事件这样会导致所有的监听器都异步执行
        multicaster.setTaskExecutor(taskExecutor);
        return multicaster;
    }

}
