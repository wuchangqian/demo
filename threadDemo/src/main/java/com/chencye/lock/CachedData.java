package com.chencye.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 下面的代码展示了如何利用重入来执行升级缓存后的锁降级（为简单起见，省略了异常处理）
 * 
 */
public class CachedData
{
    Object data;
    volatile boolean cacheValid;
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    void processCachedData()
    {
        rwl.readLock().lock();
        if (!cacheValid)
        {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock(); // 锁降级
            rwl.writeLock().lock();
            // Recheck state because another thread might have acquired
            // write lock and changed state before we did.
            if (!cacheValid) // 由于是并发，需要再次判断
            {
                // data = ...
                cacheValid = true;
            }
            // Downgrade by acquiring read lock before releasing write lock
            rwl.readLock().lock();
            rwl.writeLock().unlock(); // Unlock write, still hold read
        }
        
        // use(data);
        rwl.readLock().unlock();
    }
}
