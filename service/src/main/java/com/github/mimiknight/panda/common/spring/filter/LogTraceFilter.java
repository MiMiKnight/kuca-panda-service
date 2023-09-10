package com.github.mimiknight.panda.common.spring.filter;

import com.github.mimiknight.panda.common.constant.Constant;
import org.slf4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 日志跟踪过滤器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 21:36:42
 */
public class LogTraceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置当前请求线程中的跟踪ID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        MDC.put(Constant.Logger.MDC_TRACE_ID_KEY, uuid);
        // 执行被跟踪的代码逻辑
        chain.doFilter(request, response);
        // 清除当前请求线程中的跟踪ID
        MDC.clear();
    }

}
