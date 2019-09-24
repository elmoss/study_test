package com.study.CacheFrame;


/**
 * @author xinfei.wang on 2019/9/24.
 */
public class Memorizer1 implements Computable<String, Integer> {

    @Override
    public Integer compute(String arg) {
        /**
         * 复杂的计算后得到一个值
         */
        return new Integer(arg);
    }
}
