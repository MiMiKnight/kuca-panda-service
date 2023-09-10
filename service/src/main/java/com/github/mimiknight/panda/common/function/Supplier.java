package com.github.mimiknight.panda.common.function;

@FunctionalInterface
public interface Supplier<T> {

    T get() throws Throwable;
}
