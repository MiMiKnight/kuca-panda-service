package com.github.mimiknight.panda.common.utils.impl;

import com.github.mimiknight.panda.common.constant.Constant;
import com.github.mimiknight.panda.common.utils.standard.LogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 日志工具接口实现类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 20:25:46
 */
@Slf4j
@Component
public class LogServiceImpl implements LogService {

    /**
     * 日志跟踪方法
     *
     * @param trackedCode 被跟踪的代码逻辑
     */
    @Override
    public void logTrace(Runnable trackedCode) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 设置当前请求线程中的跟踪ID
        MDC.put(Constant.Logger.MDC_TRACE_ID_KEY, uuid);
        // 执行被跟踪的代码逻辑
        trackedCode.run();
        // 清除当前请求线程中的跟踪ID
        MDC.clear();
    }

    /**
     * 日志跟踪方法
     *
     * @param trackedCode 被跟踪的代码逻辑
     * @return {@link T}
     */
    @Override
    public <T> T logTrace(Supplier<T> trackedCode) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 设置当前请求线程中的跟踪ID
        MDC.put(Constant.Logger.MDC_TRACE_ID_KEY, uuid);
        // 执行被跟踪的代码逻辑
        T result = trackedCode.get();
        // 清除当前请求线程中的跟踪ID
        MDC.clear();
        return result;
    }
}
