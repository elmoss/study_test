package com.study.CacheFrame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinfei.wang on 2019/9/24.
 * 弊端：hashMap不是线程安全，加synchronized关键字，但有很多线程竞争，HashMap.put容易造成死循环，用ConcurrentHashMap
 * 为什么不用HashTable，HashTable效率低，用synchronized保证线程安全，容易造成线程阻塞和等待，而且第一个线程put，第二个线程都get不了
 */
public class Memorizer2<K, V> implements Computable<K, V> {
    private final Map<K, V> cache = new HashMap<>();
    private final Computable<K, V> self;


    public Memorizer2(Computable<K, V> self) {
        this.self = self;
    }

    @Override
    public synchronized V compute(K arg) throws InterruptedException {
        V val = cache.get(arg);
        if (val == null) {
            V compute = self.compute(arg);
            cache.put(arg, compute);
        }
        return val;
    }
}
