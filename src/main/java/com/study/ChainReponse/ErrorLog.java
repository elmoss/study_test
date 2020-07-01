package com.study.ChainReponse;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class ErrorLog extends AbstractLog {

    public ErrorLog(int level) {
        this.LEVEL = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("i'm error log, print:"+ msg);

    }
}
