package com.study.CacheFrame;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author xinfei.wang on 2019/9/24.
 * 上一个版本ConcurrentHashMap 的确能减少很多并发的问题，但还是会存在重复计算的问题，
 * 这里用到FutureTask 线程的返回值，
 * putIfAbsent方法会检查Map里面是否有值，并返回插入的值
 * while循环的作用是防止污染数据，主线程在执行，过程中被打断，而其他的线程在等待结果，存入到map中的Future对象是不完整的
 * 当有线程被异常中断，其他线程获取结果为null，会重新计算，
 */
public class Memorizer3<K, V> implements Computable<K, V> {
    private final Map<K, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<K, V> self;

    public Memorizer3(Computable<K, V> self) {
        this.self = self;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        while (true) {
            Future<V> v = cache.get(arg);
            if (v == null) {
                Callable<V> able = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return self.compute(arg);
                    }
                };

                FutureTask<V> task = new FutureTask<>(able);
                v = cache.putIfAbsent(arg, task);
                if (v == null) {
                    v = task;
                    task.run();
                }
            }
            try {
                return v.get();
            } catch (CancellationException c) {
                cache.remove(arg);
            } catch (ExecutionException e) {
                e.printStackTrace();
                //throw new InterruptedException(e.getMessage());
                throw launderThrowable(e.getCause());
            }
        }
    }

    private InterruptedException launderThrowable(Throwable cause) {
        if (cause instanceof InterruptedException) {
            return (InterruptedException) cause;
        }

        return new InterruptedException(cause.getMessage());
    }
}
