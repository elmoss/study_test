package com.study.ChainReponse;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class InfoLog extends AbstractLog {

    public InfoLog(int level) {
        this.LEVEL = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("i'm info log ,msg:" + msg);
    }
}