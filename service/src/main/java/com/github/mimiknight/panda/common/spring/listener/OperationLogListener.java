package com.github.mimiknight.panda.common.spring.listener;

import com.github.mimiknight.panda.common.spring.event.OperationLogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 发送操作日志监听器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-11-07 06:29:47
 */
@Slf4j
@Component
public class OperationLogListener implements ApplicationListener<OperationLogEvent> {
    @Override
    public void onApplicationEvent(OperationLogEvent event) {
        log.info("操作日志");
        int a = 1/0;
    }
}
