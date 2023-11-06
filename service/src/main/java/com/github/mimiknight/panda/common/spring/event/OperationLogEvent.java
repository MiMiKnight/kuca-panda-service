package com.github.mimiknight.panda.common.spring.event;

import org.springframework.context.ApplicationEvent;

public class OperationLogEvent extends ApplicationEvent {

    public OperationLogEvent(Object source) {
        super(source);
    }
}
