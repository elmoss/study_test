package com.study.Thread;

import java.util.concurrent.Callable;

/**
 * @author xinfei.wang on 2019/7/16.
 */
public class TestCallable implements Callable<String> {


    private String name;

    public TestCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }
}