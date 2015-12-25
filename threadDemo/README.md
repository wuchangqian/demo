###线程的使用demo

- 缓存数据安全读写
com.chencye.lock.CachedData
展示了如何利用重入来执行升级缓存后的锁降级

- 模拟线程安全的缓冲队列
com.chencye.lock.BoundedBuffer
ArrayBlockingQueue 类提供了这项功能，因此生产中没有理由去实现这个示例类。
