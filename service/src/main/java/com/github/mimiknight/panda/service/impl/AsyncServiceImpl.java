package com.github.mimiknight.panda.service.impl;

import com.github.mimiknight.panda.service.standard.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Async
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void run(Runnable function) {
        function.run();
    }

    @Override
    public <T> void run(Consumer<T> function, T value) {
        function.accept(value);
    }

    @Override
    public <T> T run(Supplier<T> function) {
        return function.get();
    }

    @Override
    public <T, R> R run(Function<T, R> function, T value) {
        return function.apply(value);
    }
}
