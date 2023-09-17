package com.github.mimiknight.panda.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 异步线程池 异常捕获处理 配置类
 * <p>
 * TODO 捕获失效 待处理
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-18 00:42:41
 */
@Slf4j
@Configuration
public class AsyncTheadExceptionHandleConfig implements AsyncConfigurer {

    @Autowired
    @Qualifier(value = "AsyncThreadPoolExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 指定线程池执行器
     *
     * @return {@link Executor}
     */
    @Override
    public Executor getAsyncExecutor() {
        return taskExecutor;
    }

    /**
     * 指定系统中的异步任务在出现异常时使用到的处理器
     *
     * @return {@link AsyncUncaughtExceptionHandler}
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    /**
     * 异步任务异常捕获处理器
     */
    private static class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            String message = throwable.getMessage();
            log.error("Async task run exception = {}", message);
        }
    }

}
