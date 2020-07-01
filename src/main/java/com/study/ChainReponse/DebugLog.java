package com.study.ChainReponse;

/**
 * @author xinfei.wang on 2020/7/1.
 */
public class DebugLog extends AbstractLog {

    public DebugLog(int level) {
        this.LEVEL = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("i'm debug info, msg:"+msg);
    }
}
