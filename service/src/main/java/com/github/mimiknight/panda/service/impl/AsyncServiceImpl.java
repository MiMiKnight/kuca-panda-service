package com.github.mimiknight.panda.service.impl;

import com.github.mimiknight.panda.service.standard.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Async
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void sendMessage(String message) {
        log.info("message = {}", message);
    }
}
