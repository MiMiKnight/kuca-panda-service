package com.github.mimiknight.panda.common.utils.standard;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 锁工具接口
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 20:28:52
 */
public interface LockService {

    /**
     * 代码块上锁
     *
     * <p>
     * 有返回值
     * <p>
     * doTryLock() 在超过等待时间过后如果还未获取到锁，则获取锁失败（false）
     *
     * @param lockName   锁名
     * @param waitTime   获取锁的等待时间
     * @param unit       锁的时间单位
     * @param lockedCode 被上锁的代码
     * @return {@link T}
     */
    <T> T doTryLock(String lockName, long waitTime, TimeUnit unit, Supplier<T> lockedCode);

    /**
     * 代码块上锁
     *
     * <p>
     * 有返回值
     * <p>
     * doTryLock() 在超过等待时间过后如果还未获取到锁，则获取锁失败（false）
     *
     * @param lockName   锁名
     * @param lockedCode 被上锁的代码
     * @return {@link T}
     */
    <T> T doTryLock(String lockName, Supplier<T> lockedCode);

    /**
     * 代码块上锁
     * <p>
     * 无返回值
     * <p>
     * doTryLock() 在超过等待时间过后如果还未获取到锁，则获取锁失败（false）
     *
     * @param lockName   锁名
     * @param waitTime   获取锁的等待时间
     * @param unit       锁的时间单位
     * @param lockedCode 被上锁的代码
     */
    void doTryLock(String lockName, long waitTime, TimeUnit unit, Runnable lockedCode);

    /**
     * 代码块上锁
     * <p>
     * 无返回值
     * <p>
     * doTryLock() 在超过等待时间过后如果还未获取到锁，则获取锁失败（false）
     *
     * @param lockName   锁名
     * @param lockedCode 被上锁的代码
     */
    void doTryLock(String lockName, Runnable lockedCode);

}
