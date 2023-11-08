package com.github.mimiknight.panda.service.standard;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface AsyncService {

    void run(Runnable function);

    <T> void run(Consumer<T> function, T value);

    <T> T run(Supplier<T> function);

    <T, R> R run(Function<T, R> function, T value);
}
