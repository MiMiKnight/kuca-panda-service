package com.github.mimiknight.panda.common.spring.listener;

import com.github.mimiknight.panda.common.spring.event.SiteMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Async
@Component
public class SendSiteMessageListener implements ApplicationListener<SiteMessageEvent> {
    @Override
    public void onApplicationEvent(SiteMessageEvent event) {
        Object source = event.getSource();
        long timestamp = event.getTimestamp();
        log.info("send site message...");
    }
}
