package com.github.mimiknight.panda.common.spring.event;

import org.springframework.context.ApplicationEvent;

public class SiteMessageEvent extends ApplicationEvent {

    public SiteMessageEvent(Object source) {
        super(source);
    }
}
