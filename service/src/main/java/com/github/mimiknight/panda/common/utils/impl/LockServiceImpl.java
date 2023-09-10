package com.github.mimiknight.panda.common.utils.impl;

import com.github.mimiknight.kuca.utils.service.standard.RedisLockService;
import com.github.mimiknight.panda.common.constant.Constant;
import com.github.mimiknight.panda.common.exception.ServiceException;
import com.github.mimiknight.panda.common.utils.standard.LockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * 锁工具接口实现类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 20:30:00
 */
@Slf4j
@Component
public class LockServiceImpl implements LockService {

    @Autowired
    private RedisLockService redisLockService;


    /**
     * 执行
     *
     * @param lockName    锁名
     * @param getLockCode 获取锁的代码
     * @param lockedCode  被锁的代码
     * @return {@link T}
     */
    private <T> T execute(String lockName, Predicate<String> getLockCode, Supplier<T> lockedCode) {
        // 如果获取锁失败则抛出异常
        if (!getLockCode.test(lockName)) {
            log.info("Failed to get the lock,lock = {}", lockName);
            // TODO 完善异常
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "107.40100001", "Failed to get the lock.");
        }
        try {
            return lockedCode.get();
        } finally {
            redisLockService.unlock(lockName);
        }
    }

    /**
     * 执行
     *
     * @param lockName    锁名
     * @param getLockCode 获取锁的代码
     * @param lockedCode  被锁的代码
     */
    private void execute(String lockName, Predicate<String> getLockCode, Runnable lockedCode) {
        // 如果获取锁失败则抛出异常
        if (!getLockCode.test(lockName)) {
            log.info("Failed to get the lock,lock = {}", lockName);
            // TODO 完善异常
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, "107.40100001", "Failed to get the lock.");
        }
        try {
            lockedCode.run();
        } finally {
            redisLockService.unlock(lockName);
        }
    }

    @Override
    public <T> T doTryLock(String lockName, long waitTime, TimeUnit unit, Supplier<T> lockedCode) {
        Predicate<String> getLockCode = key -> redisLockService.tryLock(key, waitTime, unit);
        return execute(lockName, getLockCode, lockedCode);
    }

    @Override
    public <T> T doTryLock(String lockName, Supplier<T> lockedCode) {
        return doTryLock(lockName, Constant.Redis.DEFAULT_GET_LOCK_WAITE_TIME, TimeUnit.SECONDS, lockedCode);
    }

    @Override
    public void doTryLock(String lockName, long waitTime, TimeUnit unit, Runnable lockedCode) {
        Predicate<String> getLockCode = key -> redisLockService.tryLock(key, waitTime, unit);
        execute(lockName, getLockCode, lockedCode);
    }

    @Override
    public void doTryLock(String lockName, Runnable lockedCode) {
        doTryLock(lockName, Constant.Redis.DEFAULT_GET_LOCK_WAITE_TIME, TimeUnit.SECONDS, lockedCode);
    }

}
