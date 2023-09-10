package com.github.mimiknight.panda.common.utils.standard;

import java.util.function.Supplier;

/**
 * 日志工具接口
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 20:23:48
 */
public interface LogService {

    /**
     * 日志跟踪
     *
     * @param trackedCode 被日志跟踪的代码逻辑
     */
    void logTrace(Runnable trackedCode);

    /**
     * 日志跟踪
     *
     * @param trackedCode 被日志跟踪的代码逻辑
     * @return {@link T}
     */
    <T> T logTrace(Supplier<T> trackedCode);

}
