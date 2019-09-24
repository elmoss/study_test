package com.study.CacheFrame;

/**
 * @author xinfei.wang on 2019/9/24.
 */
public interface Computable<K,V> {

    /**
     * 一个计算框架
     * @param arg
     * @return
     */
    V compute(K arg) throws InterruptedException;
}
