package com.github.mimiknight.panda.common.config.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步线程池配置类
 * <p>
 * 仅 针对使用了@Async注解的异步方法生效
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-18 00:42:41
 */
@Slf4j
@EnableAsync
@Configuration
public class AsyncTheadPoolConfig implements AsyncConfigurer {

    /**
     * 指定线程池执行器
     *
     * @return {@link Executor}
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池参数信息
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("AsyncThreadPool-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
        executor.setAwaitTerminationSeconds(60);
        // 线程执行策略
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        // 修改拒绝策略为使用当前线程执行
        executor.setRejectedExecutionHandler(callerRunsPolicy);
        // 初始化线程池
        executor.initialize();
        return executor;
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
