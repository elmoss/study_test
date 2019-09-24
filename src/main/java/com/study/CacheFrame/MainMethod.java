package com.study.CacheFrame;

/**
 * @author xinfei.wang on 2019/9/24.
 */
public class MainMethod {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 这套缓存框架适用于，某一个值经过复杂计算，得到一个不会变的值，而这些值有可能会重复计算，
         * 得到的结果会变，或者结果有时效性，这就不适用
         */
        Computable computable = new Memorizer1();
        Memorizer3<String, Integer> m = new Memorizer3<>(computable);
        Integer a1 = m.compute("a");
        Integer a2 = m.compute("b");
        Integer a3 = m.compute("a");

    }
}
