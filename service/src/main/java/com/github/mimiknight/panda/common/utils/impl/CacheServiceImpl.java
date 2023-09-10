package com.github.mimiknight.panda.common.utils.impl;

import com.github.mimiknight.kuca.utils.service.standard.RedisService;
import com.github.mimiknight.panda.common.constant.Constant;
import com.github.mimiknight.panda.common.utils.standard.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 缓存工具实现类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 21:06:29
 */
@Component
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisService redisService;

    /**
     * 做get和put
     *
     * @param cacheName 缓存键
     * @param dataType  返回值对象Class类型
     * @param code      代码块
     * @param function  函数
     * @return {@link T}
     */
    private <T> T doGetAndPut(String cacheName, Class<T> dataType,
                              Supplier<T> code, Function<Supplier<T>, T> function) {
        T result = redisService.get(cacheName, dataType);
        if (null == result) {
            result = function.apply(code);
        }
        return result;
    }

    @Override
    public <T> T getAndPut(String cacheName, Class<T> dataType, Supplier<T> code) {
        return doGetAndPut(cacheName, dataType, code, t -> {
            T result = code.get();
            redisService.set(cacheName, result, Constant.Redis.DEFAULT_CACHE_EXPIRE_TIME, TimeUnit.HOURS);
            return result;
        });
    }

    @Override
    public <T> T getAndPut(String cacheName, long expireTime,
                           TimeUnit unit, Class<T> dataType, Supplier<T> code) {
        return doGetAndPut(cacheName, dataType, code, t -> {
            T result = code.get();
            redisService.set(cacheName, result, expireTime, unit);
            return result;
        });
    }
}
